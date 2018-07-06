package Chapter10.synchronize_volatile_atomic;

// 非线程安全
// count++不是原子操作，count无法保证可见性
public class ThreadSafeV1 {
    private int count = 0;

    public void increaseCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
