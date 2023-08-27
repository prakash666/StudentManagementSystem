package com.StudentManagementSystem.StudentManagementSystem.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Enter first Name: ")
    private String firstName;
    @NotBlank (message = "Enter last Name: ")
    private String lastName;
    @NotBlank (message = "Enter address: ")
    private String address;
    @NotBlank (message = "Enter phone Number")
    private String phoneNum;
    @NotBlank(message = "Specify your gender")
    private String Gender;
    @NotBlank (message = "Enter your grade")
    private String Grade;

}
