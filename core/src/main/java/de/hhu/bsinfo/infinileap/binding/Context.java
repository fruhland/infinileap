package de.hhu.bsinfo.infinileap.binding;

import de.hhu.bsinfo.infinileap.util.MemoryAlignment;
import jdk.incubator.foreign.*;
import org.jetbrains.annotations.Nullable;

import static org.openucx.OpenUcx.*;
import static org.unix.Linux.stdout$get;

public class Context extends NativeObject implements AutoCloseable {

    private static final int UCP_MAJOR_VERSION = UCP_API_MAJOR();
    private static final int UCP_MINOR_VERSION = UCP_API_MINOR();

    /* package-private */ Context(MemoryAddress address) {
        super(address, ValueLayout.ADDRESS);
    }

    public static Context initialize(ContextParameters parameters) throws ControlException {
        return initialize(parameters, null);
    }

    public static Context initialize(ContextParameters parameters, @Nullable Configuration configuration) throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);

            /*
             * We have to use ucp_init_version at this point since ucp_init
             * is declared inline inside the header file. This makes it impossible
             * to lookup the symbol within the shared library.
             */

            var status = ucp_init_version(
                    UCP_MAJOR_VERSION,
                    UCP_MINOR_VERSION,
                    parameters.address(),
                    Parameter.ofNullable(configuration),
                    pointer.address()
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            return new Context(pointer.get(ValueLayout.ADDRESS, 0L));
        }
    }

    public Worker createWorker(WorkerParameters parameters) throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);
            var status = ucp_worker_create(
                    this.address(),
                    parameters.address(),
                    pointer.address()
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            return new Worker(pointer.get(ValueLayout.ADDRESS, 0L));
        }
    }

    public MemoryRegion allocateMemory(long size) throws ControlException {
        return allocateMemory(size, MemoryAlignment.CACHE);
    }

    public MemoryRegion allocateMemory(long size, MemoryAlignment alignment) throws ControlException {
        return mapMemory(MemorySegment.allocateNative(size, alignment.value(), ResourceScope.newImplicitScope()));
    }

    public MemoryRegion mapMemory(NativeObject object) throws ControlException {
        return mapMemory(object.segment());
    }

    public MemoryRegion mapMemory(MemorySegment segment) throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);
            var parameters = new MappingParameters().setSegment(segment);
            var size = MemorySegment.allocateNative(ValueLayout.JAVA_LONG, scope);
            var status = ucp_mem_map(
                    Parameter.of(this),
                    Parameter.of(parameters),
                    pointer.address()
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            final var handle = new MemoryHandle(pointer.get(ValueLayout.ADDRESS, 0L));
            final var descriptor = getDescriptor(segment, handle);
            return new MemoryRegion(this, handle, segment, descriptor);
        }
    }

    public ContextAttributes query() throws ControlException {
        var attributes = new ContextAttributes();
        var status = ucp_context_query(
                Parameter.of(this),
                Parameter.of(attributes)
        );

        if (Status.isNot(status, Status.OK)) {
            throw new ControlException(status);
        }

        return attributes;
    }

    public void printInfo() {
        ucp_context_print_info(
                Parameter.of(this),
                stdout$get()
        );
    }

    @Override
    public void close() {
        ucp_cleanup(Parameter.of(this));
    }

    private MemoryDescriptor getDescriptor(MemorySegment segment, MemoryHandle handle) throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);
            var size = MemorySegment.allocateNative(ValueLayout.JAVA_LONG, scope);
            var status = ucp_rkey_pack(
                    Parameter.of(this),
                    Parameter.of(handle),
                    pointer.address(),
                    size.address()
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }


            var remoteKey = MemorySegment.ofAddress(
                    pointer.get(ValueLayout.ADDRESS, 0L),
                    size.get(ValueLayout.JAVA_LONG, 0L),
                    ResourceScope.globalScope()
            );

            var descriptor = new MemoryDescriptor(segment, remoteKey);
            ucp_rkey_buffer_release(remoteKey);
            return descriptor;
        }
    }

    public static String getVersion() {
        return ucp_get_version_string().getUtf8String(0L);
    }
}
