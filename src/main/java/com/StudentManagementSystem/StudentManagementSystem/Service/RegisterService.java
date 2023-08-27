package com.StudentManagementSystem.StudentManagementSystem.Service;

import com.StudentManagementSystem.StudentManagementSystem.Entity.RegisterEntity;
import com.StudentManagementSystem.StudentManagementSystem.Entity.StudentEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;
    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository = registerRepository;
    }

    public void registerAccount(RegisterEntity registerEntity) throws DefaultException{
        List<RegisterEntity> registerEntities =registerRepository.findAll();

        for (RegisterEntity register : registerEntities){
            if (register.getUserName().equals(registerEntity.getUserName())){
                throw new DefaultException("UserName Already Exist in Database");
            } else{
                registerRepository.save(registerEntity);
            }
        }


    }








}
