package com.StudentManagementSystem.StudentManagementSystem.Service;

import com.StudentManagementSystem.StudentManagementSystem.Entity.StudentEntity;
import com.StudentManagementSystem.StudentManagementSystem.Exception.DefaultException;
import com.StudentManagementSystem.StudentManagementSystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public void postData(StudentEntity studentEntity){
        studentRepository.save(studentEntity);
    }

    public void postAllData(List<StudentEntity> studentEntities){
        studentRepository.saveAll(studentEntities);
    }

    public List<StudentEntity> getAllData() {
        return studentRepository.findAll();
    }

    public StudentEntity getData(Long id) throws DefaultException {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()){
            return optionalStudentEntity.get();
        } else {
            throw new DefaultException("Data not found");
        }
    }

    public void deleteData(Long id) throws DefaultException {
         studentRepository.deleteById(id);
    }

    public void patchData(StudentEntity studentEntity){
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(studentEntity.getId());
        if (optionalStudentEntity.isPresent()){
            StudentEntity studentEntity1 = optionalStudentEntity.get();
            if (studentEntity.getAddress()!=null){
                studentEntity1.setAddress(studentEntity.getAddress());
            }
            if (studentEntity.getGender() != null){
                studentEntity1.setGender(studentEntity.getGender());
            }
            if (studentEntity.getGrade() != null){
                studentEntity1.setGrade(studentEntity.getGrade());
            }
            if (studentEntity.getFirstName() != null){
                studentEntity1.setFirstName(studentEntity.getFirstName());
            }
            if (studentEntity.getLastName() != null){
                studentEntity1.setLastName(studentEntity.getLastName());
            }
            if (studentEntity.getPhoneNum() != null){
                studentEntity1.setPhoneNum(studentEntity.getPhoneNum());
            }
        }
        studentRepository.save(studentEntity);
    }


    public List<StudentEntity> searchData(String firstName) throws DefaultException {
         List<StudentEntity> studentEntities = studentRepository.searchData(firstName);
         if (studentEntities.isEmpty()){
             throw new DefaultException("No data found in database");
         } else {
             return studentEntities;
         }
    }

    public StudentEntity putData(StudentEntity studentEntity) throws DefaultException{
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(studentEntity.getId());
        if (optionalStudentEntity.isPresent()){
            return studentRepository.save(studentEntity);
        } else{
            throw new DefaultException("Data cannot be updated");
        }
    }
}
