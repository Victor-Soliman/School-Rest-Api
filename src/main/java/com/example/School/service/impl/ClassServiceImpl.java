package com.example.School.service.impl;

import com.example.School.Entity.ClassEntity;
import com.example.School.dto.ClassDTO;
import com.example.School.mapper.ClassMapper;
import com.example.School.repository.ClassRepository;
import com.example.School.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    ClassRepository classRepository;
    ClassMapper classMapper;

    public ClassServiceImpl(ClassRepository classRepository, ClassMapper classMapper) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
    }

    @Override
    public ClassDTO findById(Integer id) {

        return classMapper.fromEntityToDao(classRepository.findById(id).get());
    }

    @Override
    public List<ClassDTO> findAll() {
        List<ClassEntity> all = classRepository.findAll();
        List<ClassDTO> dtos = new ArrayList<>();

        for (ClassEntity dto : all) {
            ClassDTO classDTO = classMapper.fromEntityToDao(dto);
            dtos.add(classDTO);
        }

        return dtos;

    }

    @Override
    public List<ClassDTO> findByName(String name) {
//        List<ClassDTO> dtos = new ArrayList<>();
//
//        ClassEntity byName = classRepository.findByName(name);
//        ClassDTO classDTO = classMapper.fromEntityToDao(byName);
//        dtos.add(classDTO);
//
//        return dtos;
        
        return           classRepository.findByName(name).stream()
                        .map(classMapper::fromEntityToDao)
                        .collect(Collectors.toList());
    }

}
