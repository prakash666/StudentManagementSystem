package com.StudentManagementSystem.StudentManagementSystem.Repository;

import com.StudentManagementSystem.StudentManagementSystem.Entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,Long> {
    Optional<RegisterEntity> findByUserName(String userName);
}
