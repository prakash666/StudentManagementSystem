package com.StudentManagementSystem.StudentManagementSystem.Exception;

import com.StudentManagementSystem.StudentManagementSystem.Model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {



    @ExceptionHandler (MethodArgumentNotValidException.class)
    public List<StudentModel> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<StudentModel> studentModelList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            studentModelList.add(new StudentModel(fieldError.getField(),fieldError.getDefaultMessage()));
        });
        return studentModelList;
    }

    @ExceptionHandler (DefaultException.class)
    public String DefaultException(DefaultException exception){
        return exception.getLocalizedMessage();
    }







}
