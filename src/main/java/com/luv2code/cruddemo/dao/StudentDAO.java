package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student student);

    void deleteById(int id);

    int deleteAllStudents();
}
