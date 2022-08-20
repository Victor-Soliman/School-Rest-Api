package com.example.School.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {


    private int id;

    private String name;

    private String lastName;

    private LocalDate dateOfBirth;

//    private Integer classId;

    private ClassDTO classDTO;

    private String email;

}
