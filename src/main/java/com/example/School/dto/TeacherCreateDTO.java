package com.example.School.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data


public class TeacherCreateDTO {


    private String firstName;


    private String lastName;


    private Integer salary;


    private Integer subjectId;

}
