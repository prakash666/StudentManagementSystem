package com.StudentManagementSystem.StudentManagementSystem.Controller;

import com.StudentManagementSystem.StudentManagementSystem.Entity.LoginEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.DataFormatException;

@RestController()
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String LogIn(@Valid @RequestBody LoginEntity loginEntity)throws DefaultException {
        loginService.LogIn(loginEntity);
        return "you have successfully login";
    }

}
