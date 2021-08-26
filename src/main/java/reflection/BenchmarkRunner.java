package reflection;

import objects.Child1;
import objects.ObjectRealCreatorWithConstructor;
import objects.ObjectRealCreatorWithReflection;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@Fork(value = 2)
public class BenchmarkRunner {

    ObjectRealCreatorWithConstructor objectRealCreatorWithConstructor = new ObjectRealCreatorWithConstructor();
    ObjectRealCreatorWithReflection objectRealCreatorWithReflection = new ObjectRealCreatorWithReflection();


    @Benchmark
    public void getObjectWithConstructor(Blackhole bh) {
        Child1 object = objectRealCreatorWithConstructor.getObject();
        bh.consume(object);
    }

    @Benchmark
    public void getObjectWithReflection(Blackhole bh) {
        Child1 object = objectRealCreatorWithReflection.getObject();
        bh.consume(object);
    }

    @Benchmark
    public void getObjectWithReflectionWithCachedConstructor(Blackhole bh) {
        Child1 object = objectRealCreatorWithReflection.getObjectWithCachedConstructor();
        bh.consume(object);
    }
}
