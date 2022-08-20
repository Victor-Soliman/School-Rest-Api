package com.example.School.repository;

import com.example.School.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//annotation for spring to create a bean of SimpleJPARepository<Student,Integer>
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository -> hold functionality from  data management.

    // pasam parametru de tip String pentru sa stie ce sa caute ,el in spate transforma metoda asta in select * from ....


    @Override
    List<Student> findAll();

//    Student findByFirstName(String firstName);

    List<Student> findByName(String name);

    List<Student> findByNameAndLastName(String firstName, String lastName);

//    List<Student> findByClassId(Integer classId);

//    Student findById(Integer id);

    // ------


    // save

//    Student save(Student student);

    // update

    Student searchById(Integer id);

}
