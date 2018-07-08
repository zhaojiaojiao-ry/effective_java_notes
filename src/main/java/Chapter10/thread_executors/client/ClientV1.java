package Chapter10.thread_executors.client;

import Chapter10.thread_executors.task.TaskV1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// task实现了Runnable接口，无返回值，可以使用3种方法创建线程：

// 方法1：
// 用Thread创建线程（参数要实现Runnable接口）
// 执行run，调用task的run方法

// 方法2：
// 用Executor执行task（实现了Runnable接口），Executor接口需要实现execute方法，自行管理线程创建、task run等
// 执行execute方法

// 方法3:
// 用ExecutorService执行task
// ExecutorService接口实现了Executor接口
// 工厂类Executors可以用来构造多种实现了ExecutorService接口的类
// ExecutorService提供的主要功能包括
// 1) submit：提交task（实现了Runnable或Callable接口），返回Future，Future可以用来控制task执行、查看task执行状态和结果。
// 2) shutdown/shutdownNow：禁止再提交task/停止执行已经提交的task
// 3) isShutdown：executor service是否被执行过shutdown/shutdownNow
// 4) isTerminated：executor service里的全部task是否已经被终止（因为前面执行了shutdown操作）
// 5) invokeAll：提交Callable List，返回Future List
// 6) invokeAny：提交Callable List，只要任意一个task完成，返回对应task的执行结果

// Future
// 1) cancal：取消task
// 2) isCanceled：task是否被取消
// 3) isDone：task是否执行完成，执行完成包括被异常中断、被取消、正常执行完成
// 4) get：获取执行结果，阻塞等待获取成功

// FutureTask
// 实现了Future和Runnable，所以是future和task的合体
// 可以提交给Executor执行，也可以当做future从中获得执行状态

// 对比Runnable/Callable、Future/FutureTask、Thread/Executor/ExcutorService
// 可执行任务                            |   任务状态结果                                  |   任务执行器
// Runnable                             |   无结果可获取                                  |   Thread、Executor、ExecutorService
// Callable                             |   Future (通过ExecutorService.submit返回获得)   |   ExecutorService
// FutureTask(实现了Runnbable和Future）  |   FutureTask本身                                |   Thread、Executor、ExecutorService

public class ClientV1 {
    public static void main(String[] args) {
        int taskNum = 10;
        // Thread
        for (int i=0; i<taskNum; i++) {
            Thread thread = new Thread(new TaskV1(i));
            thread.run();
        }

        // Executor
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(command);
                thread.run();
            }
        };
        for (int i=0; i<taskNum; i++) {
            executor.execute(new TaskV1(i));
        }

        // ExecutorService + Runnable + Future
        ExecutorService executorService = Executors.newFixedThreadPool(taskNum);
        List<Future<?>> futures = new ArrayList<>();
        for (int i=0; i<taskNum; i++) {
            futures.add(executorService.submit(new TaskV1(i)));
        }
        for (int i=0; i<taskNum; i++) {
            if (futures.get(i).isDone()) {
                System.out.println("task " + i + " is done");
            }
        }
        executorService.shutdown();

        // Executor/ExecutorService + FutureTask
        ExecutorService executorService2 = Executors.newFixedThreadPool(taskNum);
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();
        for (int i=0; i<taskNum; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(new TaskV1(i), i);
            futureTasks.add(futureTask);
            executorService2.submit(futureTask);
        }
        for (int i=0; i<taskNum; i++) {
            if (futureTasks.get(i).isDone()) {
                try {
                    System.out.println("task" + i + " is done, result is " + futureTasks.get(i).get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        executorService2.shutdown();
    }
}
