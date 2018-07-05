package Chapter2.object_methods;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                (name != null && name.equals(student.name)) &&
                (email != null && email.equals(student.email));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int res = 0;
        if (o == null) {
            return 1;
        }
        if (age < o.age) {
            return -1;
        }
        if (age > o.age) {
            return 1;
        }
        if (name != null) {
            res = name.compareTo(o.name);
            if (res != 0) {
                return res;
            }
        }
        else {
            if (o.name != null) {
                return -1;
            }
        }
        if (email != null) {
            return email.compareTo(o.email);
        }
        else {
            if (o.email == null) {
                return 0;
            }
            else {
                return -1;
            }
        }
    }
}
