package com.sil.bulktranactionloginapp.controlles;

import com.sil.bulktranactionloginapp.annotations.RestControllerIdentifier;
import com.sil.bulktranactionloginapp.entities.StudentBulk;
import com.sil.bulktranactionloginapp.exceptionHandlers.ResourceNotFountException;
import com.sil.bulktranactionloginapp.interfaces.RestControllerIdenfierInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RestControllerIdentifier
//implement assinabletype
@RequestMapping("/api/v1")
public class StudentController implements RestControllerIdenfierInterface {
    public StudentController()
    {
      students.add( new StudentBulk(1,"AND",3.52f)) ;
        students.add( new StudentBulk(2,"AND1",3.52f)) ;
        students.add( new StudentBulk(3,"AND3",3.522f)) ;


    }

private List<StudentBulk>students = new ArrayList<>();
@GetMapping("/students")
 public List<StudentBulk>students()
 {

     return students;
 }
 @GetMapping("/student")
 public StudentBulk getStudent(@RequestParam("id") int id)
 {
   return students.stream().filter(
            s->s.id()==id).findFirst().orElseThrow(()-> new ResourceNotFountException("" +
           "Student not found with id [%d]".formatted(id)));

}

}
