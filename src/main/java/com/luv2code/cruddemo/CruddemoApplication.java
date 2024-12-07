package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
            readAllStudent(studentDAO);
//            readStudentByFirstName(studentDAO);
//            updateStudentFirstName(studentDAO);
//            deleteStudentById(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Delete all students");
        int result = studentDAO.deleteAllStudents();
        System.out.println(result);
    }

    private void deleteStudentById(StudentDAO studentDAO) {
        System.out.println("Delete student by id");
        studentDAO.deleteById(1);
    }

    private void updateStudentFirstName(StudentDAO studentDAO) {
        System.out.println("Update first name");
        Student student = studentDAO.findById(1);
        System.out.println("Student Info : " + student);
        student.setFirstName("Park");
        studentDAO.update(student);
        System.out.println("Student Info : " + student);
    }

    private void readStudentByFirstName(StudentDAO studentDAO) {
        System.out.println("read student By first name");
        List<Student> students = studentDAO.findByFirstName("John");
        students.forEach(System.out::println);
    }

    private void readAllStudent(StudentDAO studentDAO) {
        System.out.println("Read all students");
        List<Student> students = studentDAO.findAll();
        students.forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("read student");
        Student student = studentDAO.findById(1);
        System.out.println("Student Info : " + student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Create multiple students");
        Student student1 = new Student("John", "Doe", "johndoe1@gmail.com");
        Student student2 = new Student("Mary", "Doe", "johndoe2@gmail.com");
        Student student3 = new Student("Born", "Doe", "johndoe3@gmail.com");

        System.out.println("Save multiple students");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Student Info : " + student1);
        System.out.println("Student Info : " + student2);
        System.out.println("Student Info : " + student3);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("create Student");
        Student student = new Student("Paul", "Doe", "paul@gmail.com");

        System.out.println("save Student");
        studentDAO.save(student);

        System.out.println("Student Info : " + student);
    }
}
