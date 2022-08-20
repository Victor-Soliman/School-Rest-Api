package com.example.School.service;

import com.example.School.Entity.Teacher;
import com.example.School.dto.TeacherCreateDTO;
import com.example.School.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    TeacherDTO findById(Integer id);

    List<TeacherDTO> findAll();

    List<TeacherDTO> findByFirstName(String firstName);

    List<TeacherDTO> findByLastName(String lastName);

    List<TeacherDTO> findByFirstNameAndLastName(String firstName, String lastName);

    TeacherDTO createTeacher(TeacherCreateDTO createDTO);

    TeacherDTO updateTeacher(Integer id, Teacher toBeUpdatedTeacher);

    String deleteTeacher(Integer id);
}
