package com.example.School.mapper.impl;

import com.example.School.Entity.ClassEntity;
import com.example.School.Entity.Student;
import com.example.School.dto.StudentDTO;
import com.example.School.mapper.ClassMapper;
import com.example.School.mapper.StudentMapper;
import com.example.School.repository.ClassRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {
    private final ClassRepository classRepository;
    private final ClassMapper classMapper;

    public StudentMapperImpl(ClassRepository classRepository, ClassMapper classMapper) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
    }

    @Override
    public StudentDTO fromEntityToDto(Student entity) {
        ClassEntity classEntity = classRepository.findById(entity.getClassId()).get();

        StudentDTO dto = StudentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .dateOfBirth(entity.getDateOfBirth())
//                .classId(entity.getClassId())
                .email(entity.getEmail())
                .classDTO(classMapper.fromEntityToDao(classEntity))
                .build();

        return dto;
    }

//    public Student fromDtoToEntity(StudentDTO dto) {
//
//        Student student = Student.builder()
//                .id(dto.getId())
//                .name(dto.getName())
//                .lastName(dto.getLastName())
//                .dateOfBirth(dto.getDateOfBirth())
//                .email(dto.getEmail())
//                .build();
//        return student;
//    }
}
