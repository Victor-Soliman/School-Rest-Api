package com.example.School.service.impl;

import com.example.School.dto.SubjectDTO;
import com.example.School.mapper.SubjectMapper;
import com.example.School.repository.SubjectRepository;
import com.example.School.service.SubjectService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;
    SubjectMapper subjectMapper;

    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectDTO findById(Integer id) {
        return subjectMapper.fromEntityToDto(subjectRepository.findById(id).get());
    }

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> findByName(String name) {
        return subjectRepository.findSubjectBySubjectName(name).stream()
                .map(sub -> subjectMapper.fromEntityToDto(sub))
                .toList();
    }

    @Override
    public List<SubjectDTO> findByTeza(Integer teza) {
        return subjectRepository.findByTeza(teza).stream()
                .map(subjectMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }
}
