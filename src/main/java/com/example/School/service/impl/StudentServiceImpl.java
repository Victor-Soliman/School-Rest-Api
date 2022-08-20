package com.example.School.service.impl;

import com.example.School.Entity.Student;
import com.example.School.dto.StudentDTO;
import com.example.School.mapper.StudentMapper;
import com.example.School.repository.StudentRepository;
import com.example.School.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.fromEntityToDto(student))
                .collect(Collectors.toList());
    }


    public List<Student> findAllByClassId(Integer id) {
        return null;
    }

    public List<StudentDTO> findAllByFirstName(String firstName) {
        return studentRepository.findByName(firstName).stream()
                .map(studentMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public StudentDTO findById(Integer id) {
        return studentMapper.fromEntityToDto(studentRepository.findById(id).get());
    }

    public List<StudentDTO> findByFirstName(String firstName) {

        return studentRepository.findByName(firstName).stream()
                .map(studentMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }


//    public StudentDTO findByName(String name) {
//        return studentMapper.fromEntityToDto(studentRepository.findByFirstName(name));
//    }

    // save methods
//    @Override
//    public Student save(StudentDTO student) {
//
//        Student aStudent = studentMapper.fromDtoToEntity(student);
//        Student savedStudent = studentRepository.save(aStudent);
//
//        return savedStudent;
//
//    }

    // update

//    @Override
//    public StudentDTO searchById(Integer id) {
//        Student student = studentRepository.searchById(id);
//        StudentDTO studentDTO = studentMapper.fromEntityToDto(student);
//        return studentDTO;
//    }

}