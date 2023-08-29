package com.StudentManagementSystem.StudentManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class ForgetPasswordEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank (message = "Enter old username")
    private String username;
    @NotBlank (message = "Enter New password")
    private String newPassword;
    @NotBlank (message = "Enter current password")
    private String reTypePassword;
}
