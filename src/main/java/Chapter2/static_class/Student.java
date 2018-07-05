package Chapter2.static_class;

// static类
// 外部类不区分static与否，统一不允许使用static标识；
// 内部类有static和非static之分，是为了区分内部类实例化的时候是否需要外部类的实例，注意static内部类也是可以实例化的，多次实例化的
public class Student {
    private String name;
    private int age;
    private String email;

    // 用builder构造要build的对象
    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    // static内部类，如Builder这种角色，在实例化StudentBuilder对象时并不希望依赖外部类Student的实例，所以标识为static
    public static class StudentBuilder {
        // 作为Builder这种角色，需要重复定义要build的对象的、和build相关的属性
        private String name;
        private int age;
        private String email;

        // builder的构造函数参数为必选属性列表
        public StudentBuilder(String name) {
            this.name = name;
        }

        // 对于每个可选属性XXX，定义对应的withXXX方法实现set，方法返回是当前的builder实例，这是为了达到chain调用的效果
        public StudentBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        // build方法，调用目标类的构造函数，将当前builder实例作为参数传递
        public Student build() {
            return new Student(this);
        }
    }

    // 非static内部类，比如ArrayList类内部的ArrayListIterator
    // 可以使用外部类中的属性
    // 内部类实例化的时候必须依赖于一个外部类的实例
    public class DerivedInfo {
        private String code;

        public DerivedInfo() {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(String.valueOf(age));
            sb.append(email);
            code = sb.toString();
        }

        @Override
        public String toString() {
            return "DerivedInfo{" +
                    "code='" + code + '\'' +
                    '}';
        }
    }

    public DerivedInfo getDerivcedInfo() {
        return new DerivedInfo();
    }
}
