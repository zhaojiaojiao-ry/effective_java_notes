package Chapter6;

public class Client {
    public static void main(String[] args) {
        Shape largeCircle = Circle.LARGE;// 因为枚举类实现了接口Shape，此处可以声明Shape类型的引用
        Shape smallCircle = Circle.SMALL;
        System.out.println(largeCircle.getArea());
        System.out.println(smallCircle.getPerimeter());

        for (Shape circle : Circle.values()) {// 枚举类的values方法，返回全部枚举值
            System.out.println(circle);
        }

        System.out.println(Circle.valueOf("LARGE"));// 枚举类的valueOf方法，根据参数输入的名称返回对应的枚举值
    }
}
