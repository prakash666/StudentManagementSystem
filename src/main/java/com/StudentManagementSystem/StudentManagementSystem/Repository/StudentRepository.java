package com.StudentManagementSystem.StudentManagementSystem.Repository;
import com.StudentManagementSystem.StudentManagementSystem.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query (value = "SELECT * FROM student_entity WHERE first_name= :firstName",nativeQuery = true)
    List<StudentEntity> searchData(String firstName);
}
