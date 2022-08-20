package com.example.School.mapper;

import com.example.School.Entity.Student;
import com.example.School.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {
    StudentDTO fromEntityToDto(Student entity);

//   Student fromDtoToEntity(StudentDTO dto);
}
