package com.lore.sio.controller;

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

import com.lore.sio.service.CourseService;
import com.lore.sio.model.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService serv;

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
        return serv.list(id);
    } 

    @GetMapping
    public ResponseEntity<?> list(){
        return serv.list();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Course course){
        return serv.create(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Course course,@PathVariable("id") Long id){
        return serv.update(course, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return serv.delete(id);
    }
}