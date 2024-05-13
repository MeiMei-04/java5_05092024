/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Java5_05092024.controller;

import com.example.Java5_05092024.Dao.StudentDao;
import com.example.Java5_05092024.entity.Student;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HieuCute
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    StudentDao studentDao;
    List<Student> Students;

    public StudentController() {
        studentDao = new StudentDao();
        Students = studentDao.getAllData();
    }

    @ModelAttribute("Students")
    public List<Student> getDataStudents() {
        return Students;
    }

    @GetMapping("/list")
    public String index() {
        return "student/index";
    }

    @PostMapping("/event")
    public String addStudent(
            @RequestParam("ip_name") String name,
            @RequestParam("ip_age") String age,
            @RequestParam("ip_class") String mYClass,
            @RequestParam("acction") String acction,
            @RequestParam("ip_id") String idStr
    ) 
    {
        int id = studentDao.getIdStudent();
        if (name.equals("")) {

        } else if (age.equals("")) {

        } else if (acction.equals("")) {

        } else {
            if (acction.equals("add")) {
                    Student student = new Student(id, name, Integer.parseInt(age), mYClass);
                    boolean isAdd = studentDao.addStudent(student);
                    System.out.println(isAdd);
            }else if(acction.equals("edit")){
                if(idStr.equals("")){
                    
                }else{
                    int index = studentDao.getIndexStudent(Integer.parseInt(idStr));
                    Student student = new Student(Integer.parseInt(idStr), name, Integer.parseInt(age), mYClass);
                    boolean isUpdate = studentDao.updateStudent(index,student);
                }
                
            }
        }
        return "redirect:/student/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model) {
        if (id != null) {
            int index = studentDao.getIndexStudent(Integer.parseInt(id));
            System.out.println("index" + index);
            Student student = Students.get(index);
            model.addAttribute("student", student);
        }
        return "student/index";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        if (id != null) {
            int index = studentDao.getIndexStudent(Integer.parseInt(id));
            studentDao.deleteStudent(index);
        }
        return "redirect:/student/list";
    }
}
