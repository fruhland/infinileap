package de.hhu.bsinfo.infinileap.binding;

import de.hhu.bsinfo.infinileap.util.FileDescriptor;
import jdk.incubator.foreign.*;

import static org.openucx.Communication.ucp_request_cancel;
import static org.openucx.Communication.ucp_request_free;
import static org.openucx.OpenUcx.*;
import static org.openucx.Communication.ucp_tag_recv_nbx;

public class Worker extends NativeObject implements AutoCloseable {

    /* package-private */ Worker(MemoryAddress address) {
        super(address, ValueLayout.ADDRESS);
    }

    public WorkerAddress getAddress() throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);
            var length = MemorySegment.allocateNative(ValueLayout.JAVA_LONG, scope);
            var status = ucp_worker_get_address(
                    Parameter.of(this),
                    pointer,
                    length
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            return new WorkerAddress(pointer.get(ValueLayout.ADDRESS, 0L), length.get(ValueLayout.JAVA_LONG, 0L));
        }
    }

    public WorkerProgress progress() {
        return ucp_worker_progress(this.address()) == 0 ? WorkerProgress.IDLE : WorkerProgress.ACTIVE;
    }

    public Status arm() {
        return Status.of(ucp_worker_arm(Parameter.of(this)));
    }

    public Status await() {
        return Status.of(ucp_worker_wait(Parameter.of(this)));
    }

    public Status signal() {
        return Status.of(ucp_worker_signal(Parameter.of(this)));
    }

    public Endpoint createEndpoint(EndpointParameters parameters) throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);
            var status = ucp_ep_create(
                    Parameter.of(this),
                    Parameter.of(parameters),
                    pointer
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            return new Endpoint(pointer.get(ValueLayout.ADDRESS, 0L));
        }
    }

    public Listener createListener(ListenerParameters parameters) throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var pointer = MemorySegment.allocateNative(ValueLayout.ADDRESS, scope);
            var status = ucp_listener_create(
                    Parameter.of(this),
                    Parameter.of(parameters),
                    pointer
            );

            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            return new Listener(pointer.get(ValueLayout.ADDRESS, 0L));
        }
    }

    public long receiveTagged(NativeObject object, Tag tag) {
        return receiveTagged(object.segment(), tag, RequestParameters.EMPTY);
    }

    public long receiveTagged(NativeObject object, Tag tag, RequestParameters parameters) {
        return receiveTagged(object.segment(), tag, parameters);
    }

    public long receiveTagged(MemorySegment buffer, Tag tag) {
        return receiveTagged(buffer, tag, RequestParameters.EMPTY);
    }

    public long receiveTagged(MemorySegment buffer, Tag tag, RequestParameters parameters) {
        return ucp_tag_recv_nbx(
                Parameter.of(this),
                buffer,
                buffer.byteSize(),
                tag.getValue(),
                tag.getValue(),
                Parameter.of(parameters)
        );
    }

    public void setHandler(HandlerParameters parameters) throws ControlException {
        var status = ucp_worker_set_am_recv_handler(
                Parameter.of(this),
                Parameter.of(parameters)
        );

        if (Status.isNot(status, Status.OK)) {
            throw new ControlException(status);
        }
    }

    public FileDescriptor fileDescriptor() throws ControlException {
        try (var scope = ResourceScope.newConfinedScope()) {
            var descriptor = MemorySegment.allocateNative(ValueLayout.JAVA_INT, scope);
            var status = ucp_worker_get_efd(
                Parameter.of(this),
                descriptor
            );


            if (Status.isNot(status, Status.OK)) {
                throw new ControlException(status);
            }

            return FileDescriptor.of(descriptor.get(ValueLayout.JAVA_INT, 0L));
        }
    }

    public void cancelRequest(long request) {
        if (!Status.isStatus(request)) {
            ucp_request_cancel(Parameter.of(this), request);
            ucp_request_free(request);
        }
    }

    @Override
    public void close() {
        ucp_worker_destroy(segment());
    }
}
