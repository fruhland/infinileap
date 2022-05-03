package de.hhu.bsinfo.infinileap.common.util;

import de.hhu.bsinfo.infinileap.common.memory.MemoryUtil;
import jdk.incubator.foreign.*;

public class NativeObject {

    /**
     * This struct's backing memory segment.
     */
    private final MemorySegment segment;

    /**
     * This struct's base address within its segment.
     */
    private final MemoryAddress baseAddress;

    protected NativeObject(MemorySegment segment) {
        if (segment.address().equals(MemoryAddress.NULL)) {
            throw new IllegalArgumentException("memory address is pointing at null");
        }

        if (!segment.scope().isAlive()) {
            throw new IllegalArgumentException("the provided segment's scope must be alive");
        }

        this.segment = segment;
        baseAddress = segment.address();
    }

    protected NativeObject(MemoryAddress address, MemoryLayout layout) {
        this(address, layout.byteSize());
    }

    protected NativeObject(MemoryAddress address, long byteSize) {
        // Since accessing memory obtained from native functions is
        // considered dangerous, we need to create a restricted
        // MemorySegment first by using our base segment.
        this(MemoryUtil.wrap(address, byteSize));
    }

    public MemoryAddress address() {
        return baseAddress;
    }

    public long byteSize() {
        return segment.byteSize();
    }

    protected ResourceScope scope() {
        return segment.scope();
    }

    public final MemorySegment segment() {
        return segment;
    }

    public final byte[] toByteArray() {
        return segment.toArray(ValueLayout.JAVA_BYTE);
    }

    public final void hexDump() {
        MemoryUtil.dump(segment);
    }
}
