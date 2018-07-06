package Chapter10.synchronize_volatile_atomic;

import java.util.concurrent.atomic.AtomicInteger;

// 用volatile和AtomicInteger，分别保证可见性和原子性
public class ThreadSafeV3 {
    private volatile AtomicInteger count = new AtomicInteger();// volatile保证可见性，Atomic保证原子性

    public void increaseCount() {
        count.getAndAdd(1);// getAndAdd是原子操作，所以可以保证increaseCount方法的原子性
    }

    public int getCount() {
        return count.get();
    }
}
