package com.example.School.controller;


import com.example.School.Entity.Subject;
import com.example.School.dto.SubjectDTO;
import com.example.School.repository.SubjectRepository;
import com.example.School.service.SubjectService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping( "/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;


    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> findAll(@RequestParam(name = "name", required = false) String subName) {

        if (subName != null) {

            return ResponseEntity.ok(subjectService.findByName(subName));

        } else

            return ResponseEntity.ok(subjectService.findAll());
    }


    @GetMapping({"{id}"})
    public ResponseEntity<SubjectDTO> findById(@PathVariable("id") Integer id) {

        SubjectDTO serviceById = subjectService.findById(id);

        return ResponseEntity.ok(serviceById);
    }
}
