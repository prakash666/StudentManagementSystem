package com.StudentManagementSystem.StudentManagementSystem.Controller;

import com.StudentManagementSystem.StudentManagementSystem.Entity.RegisterEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegisterController {
    private final RegisterService registerService;
    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@Valid @RequestBody RegisterEntity registerEntity) throws DefaultException {
        registerService.registerAccount(registerEntity);
        return ResponseEntity.ok("User has been successfully registered!!");
    }








}
