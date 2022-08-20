package com.example.School.service;

import com.example.School.Entity.Subject;
import com.example.School.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    SubjectDTO findById(Integer id);

    List<SubjectDTO> findAll();

    List<SubjectDTO> findByName(String name);

    List<SubjectDTO> findByTeza(Integer teza);


}
