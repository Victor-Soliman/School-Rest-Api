package com.example.School.controller;

import com.example.School.Entity.Student;
import com.example.School.dto.StudentDTO;
import com.example.School.repository.StudentRepository;
import com.example.School.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/students")
//la requestMapping poti puve value="..." , sau path=" ... " ,sau il lasi fara nimic

public class StudentController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;


    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @GetMapping
    public ResponseEntity<List<StudentDTO>>
    findAll(@RequestParam(name = "first_name", required = false) String firstName) {

        if (firstName != null) {
            return ResponseEntity.ok(studentService.findByFirstName(firstName));
        } else {
            return ResponseEntity.ok(studentService.findAll());
        }

    }

    @GetMapping({"/{id}"})
    public ResponseEntity<StudentDTO> findById(@PathVariable(name = "id") Integer idParam) {
        return ResponseEntity.ok(studentService.findById(idParam));

    }

    // save Student in DataBaze

    //    @PostMapping(value = "/api/save")
//    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO student) {
//
//        return ResponseEntity.ok(studentService.save(student));
//
//    }
//    @PostMapping(value = "/api/save")
//    public String save(@RequestBody Student student) {
//
//        studentRepository.save(student);
//
//        return "Saved ...";
//    }

    //update

//    @PutMapping(value = "/update/{id}")
//    public String updateStudent(@PathVariable Integer id, @RequestBody Student student) {
//        StudentDTO studentDTO = studentService.searchById(id);
//        studentDTO.setName(student.getName());
//        studentDTO.setLastName(student.getLastName());
//        studentDTO.setDateOfBirth(student.getDateOfBirth());
//        studentDTO.setEmail(student.getEmail());
//        studentRepository.save(student);
//
//        return "Updated ...";
//    }
}
