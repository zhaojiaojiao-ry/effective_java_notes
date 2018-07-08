package Chapter10.thread_executors.task;

public class TaskV1 implements Runnable {
    private int count;
    private int max;

    public TaskV1(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i=0; i<max; i++) {
            count = count*2 + 1;
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return "TaskV1{" +
                "count=" + count +
                ", max=" + max +
                '}';
    }
}
