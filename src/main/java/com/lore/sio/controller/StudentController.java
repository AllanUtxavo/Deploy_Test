package com.lore.sio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.lore.sio.service.StudentService;
import com.lore.sio.model.Student;

@CrossOrigin("localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService serv;


    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
        return serv.list(id);
    } 

    @PostMapping("add/sponsor/{studentId}/{sponsorId}")
    public ResponseEntity<?> addSponsor(@PathVariable("studentId") Long studentId,@PathVariable("sponsorId") Long sponsorId){
      return serv.addSponsor(studentId,sponsorId);
    }
    
    @GetMapping
    public ResponseEntity<?> list(){
        return serv.list();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student){
        return serv.create(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Student student,@PathVariable("id") Long id){
        return serv.update(student, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return serv.delete(id);
    }
}