package com.lore.sio.controller;

import com.lore.sio.model.Enrollment;
import com.lore.sio.service.EnrollmentService;
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

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService serv;

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
        return serv.list(id);
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return serv.list();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Enrollment enrollment){
        return serv.create(enrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Enrollment enrollment,@PathVariable("id") Long id){
        return serv.update(enrollment, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return serv.delete(id);
    }

}
