package Chapter6;

// 枚举类可以实现接口，但枚举类本身不能被继承
public enum Circle implements Shape {
    // 枚举变量可以由指定的成员变量构造，只要定义成员变量，并在构造函数的参数列表中指明成员变量
    LARGE(10),
    MEDIUM(5),
    SMALL(1);

    private int radius;

    // 构造函数参数列表和枚举变量申明的参数列表对应
    Circle(int radius) {
        this.radius = radius;
    }

    // 实现接口中定义的方法
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
