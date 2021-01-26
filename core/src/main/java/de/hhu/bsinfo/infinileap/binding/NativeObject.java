package de.hhu.bsinfo.infinileap.binding;

import de.hhu.bsinfo.infinileap.util.MemoryUtil;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

public class NativeObject implements AutoCloseable {

    /**
     * The {@link MemorySegment} used to interact with memory
     * obtained through native function calls.
     */
    private static final MemorySegment BASE = MemorySegment.ofNativeRestricted();

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

        if (!segment.isAlive()) {
            throw new IllegalArgumentException("the provided segment must be alive");
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
        this(BASE.asSlice(address, byteSize));
    }

    protected MemoryAddress address() {
        return baseAddress;
    }

    protected final MemorySegment segment() {
        return segment;
    }

    public final byte[] toByteArray() {
        return segment.toByteArray();
    }

    public final void hexDump() {
        MemoryUtil.dump(segment);
    }

    @Override
    public void close() {
        try {
            segment.close();
        } catch (Exception e) {
            // ignore
        }
    }
}
