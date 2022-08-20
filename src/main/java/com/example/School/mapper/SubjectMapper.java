package com.example.School.mapper;

import com.example.School.Entity.Subject;
import com.example.School.dto.SubjectDTO;
import org.springframework.stereotype.Component;

@Component
public interface SubjectMapper {

     SubjectDTO fromEntityToDto(Subject entity);
}
