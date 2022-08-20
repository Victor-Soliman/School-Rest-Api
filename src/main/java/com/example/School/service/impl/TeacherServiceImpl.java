package com.example.School.service.impl;

import com.example.School.Entity.Teacher;
import com.example.School.dto.TeacherCreateDTO;
import com.example.School.dto.TeacherDTO;
import com.example.School.mapper.TeacherMapper;
import com.example.School.repository.TeacherRepository;
import com.example.School.service.TeacherService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherMapper teacherMapper;

    TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherMapper teacherMapper, TeacherRepository teacherRepository) {
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO findById(Integer id) {
        return teacherMapper.fromEntityToDTO(teacherRepository.findById(id).get());
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> findByFirstName(String firstName) {
        return teacherRepository.findByFirstName(firstName).stream()
                .map(teacherMapper::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> findByLastName(String lastName) {
        return teacherRepository.findByLastName(lastName).stream()
                .map(teacherMapper::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> findByFirstNameAndLastName(String firstName, String lastName) {
        return teacherRepository.findByFirstNameAndLastName(firstName, lastName).stream()
                .map(teacher -> teacherMapper.fromEntityToDTO(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO createTeacher(TeacherCreateDTO createDTO) {
        Teacher postedTeacher = teacherMapper.toEntity(createDTO);
        Teacher savedTeacher = teacherRepository.save(postedTeacher);

        return teacherMapper.fromEntityToDTO(savedTeacher);
    }

    @Override
    public TeacherDTO updateTeacher(Integer id, Teacher toBeUpdatedTeacher) {
        Teacher teacherToUpdate = teacherRepository.findById(id).get();

        teacherToUpdate.setFirstName(toBeUpdatedTeacher.getFirstName());
        teacherToUpdate.setLastName(toBeUpdatedTeacher.getLastName());
        teacherToUpdate.setSalary(toBeUpdatedTeacher.getSalary());
        teacherToUpdate.setSubjectId(toBeUpdatedTeacher.getSubjectId());

        teacherToUpdate = teacherRepository.save(teacherToUpdate);

        return teacherMapper.fromEntityToDTO(teacherToUpdate);
    }

    @Override
    public String deleteTeacher(Integer id) {
        TeacherDTO deletedTeacherDTO = teacherMapper.fromEntityToDTO(teacherRepository.findById(id).get());
        teacherRepository.deleteById(id);
        return "deleted : " + deletedTeacherDTO;
    }
}
