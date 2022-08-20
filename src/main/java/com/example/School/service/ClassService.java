package com.example.School.service;

import com.example.School.dto.ClassDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    ClassDTO findById(Integer id);

    List<ClassDTO> findAll();

    List<ClassDTO> findByName(String name);
}
