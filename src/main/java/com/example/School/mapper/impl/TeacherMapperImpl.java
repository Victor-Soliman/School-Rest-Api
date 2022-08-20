package com.example.School.mapper.impl;

import com.example.School.Entity.Teacher;
import com.example.School.dto.TeacherCreateDTO;
import com.example.School.dto.TeacherDTO;
import com.example.School.mapper.TeacherMapper;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImpl implements TeacherMapper {
    @Override
    public TeacherDTO fromEntityToDTO(Teacher entity) {

        TeacherDTO dto = TeacherDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();

        return dto;
    }

    @Override
    public Teacher toEntity(TeacherCreateDTO createDTO) {

        return Teacher.builder()
                .firstName(createDTO.getFirstName())
                .lastName(createDTO.getLastName())
                .salary(createDTO.getSalary())
                .subjectId(createDTO.getSubjectId())
                .build();
    }

}
