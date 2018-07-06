package Chapter10.synchronize_volatile_atomic;

// 用synchronized实现线程安全
// 在对count进行读和写操作时，都加上synchronized
public class ThreadSafeV2 {
    private int count = 0;

    public synchronized void increaseCount() {// 此处synchronized保证了互斥同步和可见性（线程修改了线程内存的count后会立刻把线程内存同步到共享内存）
        count++;
    }

    public synchronized int getCount() {// 此处synchronized保证了可见性（线程读取count时会从共享内存读取，而不是线程内存）
        return count;
    }
}
