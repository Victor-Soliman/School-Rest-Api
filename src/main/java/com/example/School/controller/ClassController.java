package com.example.School.controller;

import com.example.School.Entity.ClassEntity;
import com.example.School.dto.ClassDTO;
import com.example.School.repository.ClassRepository;
import com.example.School.service.ClassService;
import com.example.School.service.impl.ClassServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/classes")
public class ClassController {

    ClassService classService;


    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<List<ClassDTO>> findAll
            (@RequestParam(name = "class_name", required = false) String className) {

        if (className != null) {

            return ResponseEntity.ok(classService.findByName(className));

        } else {

            return ResponseEntity.ok(classService.findAll());
        }

    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ClassDTO> findByClassId(@PathVariable(name = "id") Integer id) {

        return ResponseEntity.ok(classService.findById(id));

    }
}

