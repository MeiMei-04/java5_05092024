/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Java5_05092024.Dao;

import com.example.Java5_05092024.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuCute
 */
public class StudentDao {

    List<Student> Students = new ArrayList<>();
    public StudentDao() {
        Student student1 = new Student(1, "Hieu", 20, "SD18301");
        Student student2 = new Student(2, "Hieu", 20, "SD18301");
        Student student3 = new Student(3, "Hieu", 20, "SD18301");
        Student student4 = new Student(4, "Hieu", 20, "SD18301");
        Students.add(student1);
        Students.add(student2);
        Students.add(student3);
        Students.add(student4);
    }
    public List<Student> getAllData(){
        return Students;
    }
    public boolean addStudent(Student student){
        int size = Students.size();
        Students.add(student);
        if(size < Students.size()){
            return true;
        }
        return false;
    }
    public int getIndexStudent(int id){
        int index = -1;
        int i = 0;
        for (Student student : Students) {
            if(student.getId() == id){
                index = i;
                break;
            }
            i++;
        }
        return index;
    }
    public int getIdStudent(){
        int size = Students.size();
        Student student = Students.get(size-1);
        return student.getId()+1;
    }
    public boolean updateStudent(int index , Student student){
        int size = Students.size();
        Students.set(index, student);
        if(size == Students.size()){
            return true;
        }
        return false;
    }
    public boolean deleteStudent(int index){
        int size = Students.size();
        Students.remove(index);
        if(size > Students.size()){
            return true;
        }
        return false;
    }
}
