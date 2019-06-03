package de.hhu.bsinfo.neutrino.verbs;

import de.hhu.bsinfo.neutrino.buffer.DeviceBuffer;
import de.hhu.bsinfo.neutrino.buffer.RegisteredBuffer;
import de.hhu.bsinfo.neutrino.struct.Result;
import de.hhu.bsinfo.neutrino.struct.Struct;
import de.hhu.bsinfo.neutrino.util.BitMask;
import de.hhu.bsinfo.neutrino.util.LinkNative;
import de.hhu.bsinfo.neutrino.util.MemoryUtil;
import de.hhu.bsinfo.neutrino.verbs.DeviceMemory.AllocationAttributes;
import de.hhu.bsinfo.neutrino.verbs.QueuePair.InitialAttributes;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@LinkNative("ibv_pd")
public class ProtectionDomain extends Struct implements AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtectionDomain.class);

    private final Context context = referenceField("context", Context::new);

    ProtectionDomain(long handle) {
        super(handle);
    }

    public Context getContext() {
        return context;
    }

    @Nullable
    public RegisteredBuffer allocateMemory(long capacity, AccessFlag... flags) {
        return registerMemory(MemoryUtil.allocateMemory(capacity), capacity, flags);
    }

    @Nullable
    private RegisteredBuffer registerMemory(long handle, long capacity, AccessFlag... flags) {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.registerMemoryRegion(getHandle(), handle, capacity, BitMask.of(flags), result.getHandle());
        if(result.isError()) {
            LOGGER.error("Registering memory region failed with error [{}]", result.getStatus());
        }

        MemoryRegion region = result.getAndRelease(MemoryRegion::new);

        return region == null ? null : new RegisteredBuffer(region);
    }

    @Nullable
    public MemoryRegion allocateNullMemoryRegion() {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.allocateNullMemoryRegion(getHandle(), result.getHandle());
        if(result.isError()) {
            LOGGER.error("Allocating null memory region failed with error [{}]", result.getStatus());
        }

        return result.getAndRelease(MemoryRegion::new);
    }

    @Nullable
    public DeviceBuffer allocateDeviceMemory(AllocationAttributes attributes, AccessFlag... flags) {
        var deviceMemory = getContext().allocateDeviceMemory(attributes);

        if(deviceMemory == null) {
            return null;
        }

        var memoryRegion = registerDeviceMemory(deviceMemory, 0, attributes.getLength(), flags);

        if(memoryRegion == null) {
            return null;
        }

        return new DeviceBuffer(deviceMemory, memoryRegion, attributes.getLength());
    }

    @Nullable
    public MemoryRegion registerDeviceMemory(DeviceMemory deviceMemory, long offset, long length, AccessFlag... flags) {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.registerDeviceMemoryAsMemoryRegion(getHandle(), deviceMemory.getHandle(), offset, length, BitMask.of(flags), result.getHandle());
        if(result.isError()) {
            LOGGER.error("Registering deviceAttributes memory as memory region failed with error [{}]", result.getStatus());
        }

        return result.getAndRelease(MemoryRegion::new);
    }

    @Nullable
    public AddressHandle createAddressHandle(AddressHandle.Attributes attributes) {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.createAddressHandle(getHandle(), attributes.getHandle(), result.getHandle());
        if(result.isError()) {
            LOGGER.error("Creating address handle failed with error [{}]", result.getStatus());
        }

        return result.getAndRelease(AddressHandle::new);
    }

    @Nullable
    public SharedReceiveQueue createSharedReceiveQueue(SharedReceiveQueue.InitialAttributes initialAttributes) {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.createSharedReceiveQueue(getHandle(), initialAttributes.getHandle(), result.getHandle());
        if (result.isError()) {
            LOGGER.error("Creating shared receive queue failed with error [{}]", result.getStatus());
        }

        return result.getAndRelease(SharedReceiveQueue::new);
    }

    @Nullable
    public QueuePair createQueuePair(InitialAttributes initialAttributes) {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.createQueuePair(getHandle(), initialAttributes.getHandle(), result.getHandle());
        if (result.isError()) {
            LOGGER.error("Creating queue pair failed with error [{}]", result.getStatus());
        }

        return result.getAndRelease(QueuePair::new);
    }

    @Override
    public void close() {
        var result = (Result) Verbs.getPoolableInstance(Result.class);

        Verbs.deallocateProtectionDomain(getHandle(), result.getHandle());
        if (result.isError()) {
            LOGGER.error("Closing deviceAttributes failed with error [{}]", result.getStatus());
        }

        result.releaseInstance();
    }
}
