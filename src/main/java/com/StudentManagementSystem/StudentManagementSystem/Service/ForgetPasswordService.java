package com.StudentManagementSystem.StudentManagementSystem.Service;

import com.StudentManagementSystem.StudentManagementSystem.Entity.ForgetPasswordEntity;
import com.StudentManagementSystem.StudentManagementSystem.Entity.RegisterEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Repository.ForgetPasswordRepository;
import com.StudentManagementSystem.StudentManagementSystem.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgetPasswordService {

    @Autowired
    public RegisterRepository registerRepository;
    private final ForgetPasswordRepository forgetPasswordRepository;
    public ForgetPasswordService (ForgetPasswordRepository forgetPasswordRepository){
        this.forgetPasswordRepository = forgetPasswordRepository;
    }

    public void forgetPassword(ForgetPasswordEntity forgetPasswordEntity) throws DefaultException {
        Optional<RegisterEntity> optionalRegisterEntity = registerRepository.findByUserName(forgetPasswordEntity.getUsername());
        if (optionalRegisterEntity.isPresent()) {
            RegisterEntity registerEntity = optionalRegisterEntity.get();
            if (forgetPasswordEntity.getNewPassword() != null) {
                registerEntity.setPassword(forgetPasswordEntity.getNewPassword());
                if (forgetPasswordEntity.getReTypePassword() != null) {
                    if (forgetPasswordEntity.getReTypePassword().equals(forgetPasswordEntity.getNewPassword())) {
                        registerRepository.save(registerEntity);
                    } else {
                        throw new DefaultException("Passwords do not match");
                    }
                }
            }
        } else {
            throw new DefaultException("User not found");
        }
    }

}
