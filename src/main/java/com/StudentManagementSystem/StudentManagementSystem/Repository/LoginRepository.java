package com.StudentManagementSystem.StudentManagementSystem.Repository;
import com.StudentManagementSystem.StudentManagementSystem.Entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LoginRepository extends JpaRepository<LoginEntity,Long> {

}
