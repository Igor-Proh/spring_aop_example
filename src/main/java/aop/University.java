package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Ihor Prokhnov", 4, 4.5);
        Student st2 = new Student("Olga Sidorova", 2, 3.5);
        Student st3 = new Student("Vasiliy Smirnov", 2, 5);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Начало работы метода getStudents");
        System.out.println(students.get(3)); // Exception !!!
        System.out.println("Information from method getStudents");
        System.out.println(students);
        return students;

    }
}
