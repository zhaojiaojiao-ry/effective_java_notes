package Chapter2.object_methods;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        Student xiaoming = new Student("xiaoming", 12, "xm");
        Student xiaomingV2 = new Student("xiaoming", 12, "xm");
        Student xiaohong = new Student("xiaohong", 12, "xh");


        Set<Student> students = new HashSet<>();
        students.add(xiaoming);
        students.add(xiaohong);
        System.out.println(students.size());
        students.add(xiaomingV2);// set去重，因为equalsTo返回true
        System.out.println(students.size());


        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(xiaoming, 1);
        studentMap.put(xiaohong, 2);
        System.out.println(studentMap.size());
        studentMap.put(xiaomingV2, 3);// map覆盖老值，因为hashCode相同
        System.out.println(studentMap.size());
        System.out.println(studentMap.toString());// 可以看到map赋值覆盖之后的情况


        Set<Student> studentSet = new TreeSet<>();
        studentSet.add(xiaoming);
        studentSet.add(xiaohong);
        System.out.println(studentSet.toString());
    }
}
