package com.example.School.mapper.impl;

import com.example.School.Entity.Subject;
import com.example.School.dto.SubjectDTO;
import com.example.School.mapper.SubjectMapper;
import com.example.School.repository.SubjectRepository;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectDTO fromEntityToDto(Subject entity) {

        SubjectDTO dto = SubjectDTO.builder()
                .id(entity.getId())
                .subjectName(entity.getSubjectName())
                .build();

        return dto;
    }
}
