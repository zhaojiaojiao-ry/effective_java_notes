package Chapter10.thread_executors.task;

import java.util.concurrent.Callable;

public class TaskV2 implements Callable<Integer> {
    private int count;
    private int max;

    public TaskV2(int max) {
        this.max = max;
    }

    @Override
    public Integer call() throws Exception {
        for (int i=0; i<max; i++) {
            count = 2*count + 1;
        }
        return count;
    }

    @Override
    public String toString() {
        return "TaskV2{" +
                "count=" + count +
                ", max=" + max +
                '}';
    }
}
