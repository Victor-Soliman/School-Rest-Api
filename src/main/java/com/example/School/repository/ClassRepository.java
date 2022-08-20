package com.example.School.repository;

import com.example.School.Entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

    @Override
    List<ClassEntity> findAll();

    Optional<ClassEntity> findById(Integer id);

    List<ClassEntity> findByName(String name);


}
