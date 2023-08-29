package com.StudentManagementSystem.StudentManagementSystem.Repository;


import com.StudentManagementSystem.StudentManagementSystem.Entity.ForgetPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgetPasswordRepository extends JpaRepository<ForgetPasswordEntity, Long> {

}
