package com.sil.bulktranactionloginapp.controlles.rest;

import com.sil.bulktranactionloginapp.entities.StudentBulk;
import com.sil.bulktranactionloginapp.exceptionHandlers.ResourceNotFountException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RestControllerIdentifier
//implement assinabletype
@RequestMapping("/api/v2")
public class StudentController2  {
    public StudentController2()
    {
      students.add( new StudentBulk(1,"AND",3.52f)) ;
        students.add( new StudentBulk(2,"AND1",3.52f)) ;
        students.add( new StudentBulk(3,"AND3",3.522f)) ;


    }

private List<StudentBulk>students = new ArrayList<>();
@GetMapping("/students2")
 public List<StudentBulk>students()
 {

     return students;
 }
 @GetMapping("/student2")
 public StudentBulk getStudent(@RequestParam("id") int id)
 {
   return students.stream().filter(
            s->s.id()==id).findFirst().orElseThrow(()-> new ResourceNotFountException("" +
           "student not found id id [%d]\".formatted(id) "));

}

}
