package de.hhu.bsinfo.infinileap.example.benchmark.context;

import de.hhu.bsinfo.infinileap.binding.ControlException;
import de.hhu.bsinfo.infinileap.example.benchmark.message.BenchmarkDetails;
import de.hhu.bsinfo.infinileap.example.util.BenchmarkType;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class AtomicIntegerContext extends BaseContext {

    @Param({ "4" })
    public int bufferSize;

    @Setup(Level.Trial)
    public void setup() throws ControlException {
        setupBenchmark();
    }

    @TearDown(Level.Trial)
    public void cleanup() {
        cleanupBenchmark();
    }

    @Override
    protected BenchmarkType getBenchmarkType() {
        return BenchmarkType.ATOMIC;
    }

    @Override
    protected void fillDetails(BenchmarkDetails details) {
        details.setBufferSize(bufferSize);
    }

    public final void blockingAtomicAdd() {
        connection.blockingAtomicAdd32();
    }
}
