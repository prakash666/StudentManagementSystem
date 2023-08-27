package com.StudentManagementSystem.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class RegisterEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank (message = "Enter firstName")
    private String firstName;
    @NotBlank  (message = "Enter lastName")
    private String lastName;
    @Column (unique = true)
    private String userName;
    @Size(min = 8)
    private String password;
    @NotBlank (message = "Enter phoneNum")
    private String phoneNum;
    @NotBlank (message = "Enter Gender")
    private String Gender;

}
