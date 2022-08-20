package com.example.School.mapper;

import com.example.School.Entity.ClassEntity;
import com.example.School.dto.ClassDTO;
import org.springframework.stereotype.Component;

@Component
public interface ClassMapper {
    ClassDTO fromEntityToDao(ClassEntity entity);
}
