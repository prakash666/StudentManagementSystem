package com.StudentManagementSystem.StudentManagementSystem.Controller;

import com.StudentManagementSystem.StudentManagementSystem.Entity.ForgetPasswordEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Service.ForgetPasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ForgetPasswordController {

    private final ForgetPasswordService forgetPasswordService;

    public ForgetPasswordController(ForgetPasswordService forgetPasswordService){
        this.forgetPasswordService = forgetPasswordService;
    }

    @PostMapping("/forgetpassword")
    public String forgetPassword(@RequestBody ForgetPasswordEntity forgetPasswordEntity) throws DefaultException {
        forgetPasswordService.forgetPassword(forgetPasswordEntity);
        return "data has been updated";
    }
}
