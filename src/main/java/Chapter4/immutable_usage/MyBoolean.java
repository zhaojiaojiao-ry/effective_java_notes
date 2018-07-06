package Chapter4.immutable_usage;


import java.util.Objects;

// 两种构造immutable类的方式
// 1. 把类声明成final，所有成员声明成final，这样此类无法继承，每次初始化后的对象都不能修改

// 2. 把类声明成非final，重要不可变成员声明成final，少量懒初始化成员声明成非final
// （如hashCode值，在第一次调用hashCode方法时才初始化，但以后不会再改变）
// 构造函数用private标识，这样包外的类不可能继承此类
// 提供public static factory方法，获取对象实例，可以通过不同的static factory方法提供满足需求的不同实例

// 更推荐第2种方法
public class MyBoolean {
    // 作为immutable类，觉得部分成员变量应该是private final的，少数懒初始化可以用非final，如hashCode
    private final boolean value;

    // 如果有一些常用的immutable实例，可以直接通过public static final的方式提供给客户端使用
    public static final MyBoolean TRUE = new MyBoolean(true);
    public static final MyBoolean FALSE = new MyBoolean(false);

    // 构造函数标识为private
    private MyBoolean(boolean value) {
        this.value = value;
    }

    // 提供public static factory给客户端申请实例使用
    public static MyBoolean valueOf(boolean value) {
        return new MyBoolean(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBoolean)) return false;
        MyBoolean myBoolean = (MyBoolean) o;
        return value == myBoolean.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
