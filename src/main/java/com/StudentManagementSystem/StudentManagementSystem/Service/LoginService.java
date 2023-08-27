package com.StudentManagementSystem.StudentManagementSystem.Service;

import com.StudentManagementSystem.StudentManagementSystem.Entity.LoginEntity;
import com.StudentManagementSystem.StudentManagementSystem.Entity.RegisterEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Repository.LoginRepository;
import com.StudentManagementSystem.StudentManagementSystem.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    public RegisterRepository registerRepository;

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void LogIn(LoginEntity loginEntity) throws DefaultException {
        Optional<RegisterEntity> registerEntity = registerRepository.findByUserName(loginEntity.getUserName());
       if (registerEntity.isEmpty() || !registerEntity.get().getPassword().equals(loginEntity.getPassword())){
            throw new DefaultException("Invalid username and password");
        } else {
           System.out.println("you have been loggedIn");
       }
    }

}


