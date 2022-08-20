package com.example.School.service;

import com.example.School.Entity.Student;
import com.example.School.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentDTO> findAll();

//    List<Student> findAllByClassId(Integer id);

//    List<Student> findAllByClassId(Integer id);

    StudentDTO findById(Integer id);

    List<StudentDTO> findByFirstName(String firstName);


    // save methods

//    Student save(StudentDTO student);

    // update

//    StudentDTO searchById(Integer id);
}
