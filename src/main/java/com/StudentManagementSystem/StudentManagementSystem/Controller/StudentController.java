package com.StudentManagementSystem.StudentManagementSystem.Controller;
import com.StudentManagementSystem.StudentManagementSystem.Entity.StudentEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/post")
    public String postData(@Valid @RequestBody StudentEntity studentEntity){
        studentService.postData(studentEntity);
        return "Data has been successfully posted ";
    }

    @PostMapping("/postAll")
    public String postAllData(@Valid @RequestBody List<StudentEntity> studentEntities){
        studentService.postAllData(studentEntities);
        return "All list of information has been posted";
    }

    @GetMapping("/getAll")
    public List<StudentEntity>getAllData(){
        return studentService. getAllData();

    }
    @GetMapping("/get/{id}")
    public StudentEntity getData(@PathVariable ("id") Long id) throws DefaultException {
        return studentService.getData(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteData(@PathVariable ("id") Long id) throws DefaultException{
         studentService.deleteData(id);
         return "data has been successfully deleted";
    }
    @PatchMapping("/patch")
    public String patchData(@RequestBody StudentEntity studentEntity){
        studentService.patchData(studentEntity);
        return "data has been updated successfully";
    }

    @GetMapping("/search/{search}")
    public List<StudentEntity> searchData (@PathVariable("search")String firstName) throws DefaultException {
        return studentService.searchData(firstName);
    }








}
