package de.hhu.bsinfo.infinileap.binding;

import de.hhu.bsinfo.infinileap.common.util.flag.LongFlag;

import static org.openucx.OpenUcx.*;

public enum MemoryType implements LongFlag {
    HOST(UCS_MEMORY_TYPE_HOST()),
    ROCM(UCS_MEMORY_TYPE_ROCM()),
    ROCM_MANAGED(UCS_MEMORY_TYPE_ROCM_MANAGED()),
    CUDA(UCS_MEMORY_TYPE_CUDA()),
    CUDA_MANAGED(UCS_MEMORY_TYPE_CUDA_MANAGED());

    private final long value;

    MemoryType(long value) {
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }
}
