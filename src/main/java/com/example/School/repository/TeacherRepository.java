package com.example.School.repository;

import com.example.School.Entity.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findById(Integer id);

//    List<Teacher> findByFirstName(String firstName);

    List<Teacher> findByFirstName(String fn);

    List<Teacher> findByLastName(String lastName);

    List<Teacher> findBySalary(Integer salary);

    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);

    //    @Override
    List<Teacher> findAll();




}
