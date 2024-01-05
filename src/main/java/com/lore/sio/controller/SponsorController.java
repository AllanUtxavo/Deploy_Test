package com.lore.sio.controller;

import com.lore.sio.model.Sponsor;
import com.lore.sio.service.SponsorService;
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

import com.lore.sio.service.SponsorService;
import com.lore.sio.model.Sponsor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService serv;

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
        return serv.list(id);
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return serv.list();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Sponsor sponsor){
        return serv.create(sponsor);
    }

    @PostMapping("/add/student/{sponsor_id}/{student_id}")
    public ResponseEntity<?> addStudent(@PathVariable("sponsor_id") Long sponsor, @PathVariable("student_id") Long student){
        return serv.addStudent(sponsor, student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Sponsor sponsor,@PathVariable("id") Long id){
        return serv.update(sponsor, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return serv.delete(id);
    }
    
}
