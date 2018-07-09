# effective_java_notes

## 2018.7.4-7.9

* chapter 2: 对象构造
> * static factory method
> * service and provider pattern
> * builder pattern
> * singleton

* chapter 3：Object子类的通用方法
> * toString
> * equals
> * hashCode
> * Comparable.compareTo
> * clone

* chapter 4: 类和接口
> * 不改变的实例对象，用static final属性定义，可复用
> * 扩展类的方法，继承or wapper class + forword class

* chapter 5：泛型
> * 尽量不使用不指定具体类型的泛型，如List
> * 异质的类如何表示，用<?>

* chapter 6：枚举
> * 枚举类可以有成员属性
> * 枚举类可以实现接口，达到扩展的效果


* chapter 7：方法
> * 注意不要误将实例内部数据暴露给客户端，getter要用防御式复制
> * 注意不要轻信客户端传入的对象实例，constructor要用防御式复制

* chapter 8：通用编程
> * 变量在第一次使用前声明
> * 多用foreach，实现Iterable接口就可用
> * 注意double、float达不到预期精确度
> * String拼接用StringBuilder，不用加号
> * 声明时尽量用接口名，构造时才用实现类名

* chapter 9：异常
> * checked exception：通过方法上加throws标识抛出，认为客户端应该可以处理的，客户端通过try catch捕获并处理
> * unchecked exception：包括runtime exception和error，不需要throws标识，是代码编写的问题

* chapter 10：并发
> * synchronized：保证同步互斥和可见性
> * volatile：保证可见性，禁止指令重排
> * Atomic：保证原子性
> * Runnble, Callable, Future, FutureTask
> * Thread, Executor, ExecutorService
> * Executors
> * 线程安全的懒加载：方法1是static内部类，方法2是volatile+double-check