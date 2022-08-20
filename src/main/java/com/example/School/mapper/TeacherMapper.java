package com.example.School.mapper;

import com.example.School.Entity.Teacher;
import com.example.School.dto.TeacherCreateDTO;
import com.example.School.dto.TeacherDTO;

public interface TeacherMapper {

    TeacherDTO fromEntityToDTO(Teacher entity);


    Teacher toEntity(TeacherCreateDTO createDTO);
}
