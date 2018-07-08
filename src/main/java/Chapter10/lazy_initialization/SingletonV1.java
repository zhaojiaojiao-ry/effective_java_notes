package Chapter10.lazy_initialization;


// static成员变量懒加载实例
// 单例场景 - 内部类实现方法
// 为了让singleton成员变量单例且懒加载，需要
// 1) 将Singleton构造函数标识成private，禁止了外部调用构造函数
// 2) 只允许外部使用getInstance工厂方法获得实例
// 3) 没有将成员变量singleton设置成final，因为final就不是懒加载了
// 4）声明private的内部类SingletonHolder，成员变量是一个static final的Singleton实例
// 5）在外部类第一次调用getInstance的时候调用内部类的static final成员变量，执行第一次初始化，之后再调用getInstance也不会重复初始化
public class SingletonV1 {
    private static SingletonV1 singleton;// static，因为是单例
    private SingletonV1() {// private，避免外部调用构造

    }

    public static SingletonV1 getInstance() {// public static，工厂方法，外部获得singleton实例的唯一方法
        return SingletonHolder.singleton;// 获取内部类的成员变量
    }

    private static class SingletonHolder {// private static，禁止外部使用的内部类，实例不依赖于外部类的实例
        public static final SingletonV1 singleton = new SingletonV1();// public static final，类加载时就初始化，且只初始化一次
    }
}
