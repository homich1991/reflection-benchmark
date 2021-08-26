package reflection;

import objects.ObjectRealCreatorWithConstructor;
import objects.ObjectRealCreatorWithReflection;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@Fork(value = 2)
public class BenchmarkRunner {

    ObjectRealCreatorWithConstructor objectRealCreatorWithConstructor = new ObjectRealCreatorWithConstructor();
    ObjectRealCreatorWithReflection objectRealCreatorWithReflection = new ObjectRealCreatorWithReflection();


    @Benchmark
    public void getObjectWithConstructor() {
        objectRealCreatorWithConstructor.getObject();
    }

    @Benchmark
    public void getObjectWithReflection() {
        objectRealCreatorWithReflection.getObject();
    }
}
