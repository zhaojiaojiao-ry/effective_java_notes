package Chapter1.static_class;

public class Client {
    public static void main(String[] args) {
        // static内部类的定义，不依赖与外部类的实例，直接用外部类的类名就可以了
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder("皎皎");
        Student student = studentBuilder.withAge(29).withEmail("jiaojiao@xxx.com").build();

        // 非static内部类，实例化依赖于外部类的具体实例
        Student.DerivedInfo derivedInfo = student.getDerivcedInfo();
        System.out.println(derivedInfo.toString());

        derivedInfo = null;
        derivedInfo = student.new DerivedInfo();
        System.out.println(derivedInfo.toString());
    }
}
