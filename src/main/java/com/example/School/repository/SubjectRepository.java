package com.example.School.repository;

import com.example.School.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Optional<Subject> findById(Integer id);

    List<Subject> findAll();

    List<Subject> findSubjectBySubjectName(String name);

    List<Subject> findByTeza(Integer teza);


}
