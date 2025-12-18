package com.sil.bulktranactionloginapp.controlles;

import com.sil.bulktranactionloginapp.annotations.MVCControllerIdentifier;
import com.sil.bulktranactionloginapp.entities.StudentBulk;
import com.sil.bulktranactionloginapp.exceptionHandlers.ResourceNotFountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
@MVCControllerIdentifier

//implement assinable type

public class StudentMVCController  {
    public StudentMVCController()
    {
        students.add( new StudentBulk(1,"AND",3.52f)) ;
        students.add( new StudentBulk(2,"AND1",3.52f)) ;
        students.add( new StudentBulk(3,"AND3",3.522f)) ;


    }

    private final List<StudentBulk> students = new ArrayList<>();
    @GetMapping("/students")
    public List<StudentBulk>students()
    {

        return students;
    }
    @GetMapping("/student")
    public String getStudent(@RequestParam("id") int id, Model model)
    {
        var student= students.stream().filter(
                s->s.id()==id).findFirst().orElseThrow(()-> new ResourceNotFountException("" +
                "Student not found with id [%d]".formatted(id)));
        model.addAttribute("student",student);
        return "student";


    }
    @GetMapping("/hellow2")
    public void dispaly()
    {

        double res = 23/0;
        if (1==1)
        {
            throw new RuntimeException("Ex----------------");
        }
    }
}
