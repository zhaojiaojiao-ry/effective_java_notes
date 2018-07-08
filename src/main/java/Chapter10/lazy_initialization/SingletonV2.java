package Chapter10.lazy_initialization;

// static成员变量懒加载实例
// 单例场景 - double check实现方法
// 为了让singleton成员变量单例且懒加载，需要
// 1) 将Singleton构造函数标识成private，禁止了外部调用构造函数
// 2) 只允许外部使用getInstance工厂方法获得实例
// 3) 没有将成员变量singleton设置成final，因为final就不是懒加载了
// 4）声明private的内部类SingletonHolder，成员变量是一个static final的Singleton实例
// 5）在外部类第一次调用getInstance的时候调用内部类的static final成员变量，执行第一次初始化，之后再调用getInstance也不会重复初始化
public class SingletonV2 {
    private static volatile SingletonV2 singleton;// volatile，禁止对singleton变量赋值的指令出现指令重排，导致线程不安全
    private SingletonV2() {

    }
    public static SingletonV2 getInstance() {
        if (singleton == null) {// double-check的原因，避免线程1、2同时到达synchronized，线程1完成创建后，线程2不check就会重复创建了
            synchronized (SingletonV2.class) {
                if (singleton == null) {
                    // 如果不使用volatile，可能出现指令重重排，先赋值给singleton，再初始化
                    // 如果在赋值之后有新线程达到，就会任务singleton非null而错误使用未初始化完成的singleton
                    singleton = new SingletonV2();
                }
            }
        }
        return singleton;
    }
}
