package com.example.School.controller;

import com.example.School.Entity.Teacher;
import com.example.School.dto.TeacherCreateDTO;
import com.example.School.dto.TeacherDTO;
import com.example.School.mapper.TeacherMapper;
import com.example.School.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

//    private final TeacherMapper teacherMapper;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
//        this.teacherMapper = teacherMapper;
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll(@RequestParam(name = "first_name", required = false) String firstName) {

        if (firstName != null) {

            return ResponseEntity.ok(teacherService.findByFirstName(firstName));

        } else {
            return ResponseEntity.ok(teacherService.findAll());

        }
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TeacherDTO> findById(@PathVariable(name = "id") Integer id){

        return ResponseEntity.ok(teacherService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> create(@RequestBody TeacherCreateDTO createDTO){

        return ResponseEntity.ok(teacherService.createTeacher(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> update(@PathVariable(name = "id") Integer id ,@RequestBody Teacher toBeUpdatedTeacher){

        return ResponseEntity.ok(teacherService.updateTeacher(id,toBeUpdatedTeacher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable (name = "id") Integer id){
        return  ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
