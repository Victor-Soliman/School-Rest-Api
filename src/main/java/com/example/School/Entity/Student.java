package com.example.School.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity(name = "Student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // in general nu trebuie sa punem @Cololmn pentru ca Hibernate stie sa faca asta
    // mai jos este doar ca sa zica ca are nume diferit

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private Integer classId;

    private String email;

    private String password;

}
