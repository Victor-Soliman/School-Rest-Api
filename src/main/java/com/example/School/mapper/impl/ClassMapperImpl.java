package com.example.School.mapper.impl;

import com.example.School.Entity.ClassEntity;
import com.example.School.dto.ClassDTO;
import com.example.School.mapper.ClassMapper;
import org.springframework.stereotype.Component;

@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassDTO fromEntityToDao(ClassEntity entity) {
        ClassDTO dto = ClassDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

        return dto;
    }
}
