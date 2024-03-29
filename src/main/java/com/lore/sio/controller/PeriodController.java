package com.lore.sio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lore.sio.model.Period;
import com.lore.sio.service.PeriodService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/period")
public class PeriodController {
    @Autowired
    private PeriodService serv;

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
        return serv.list(id);
    } 

    @GetMapping
    public ResponseEntity<?> list(){
        return serv.list();
    }
        @PostMapping
    public ResponseEntity<?> create(@RequestBody Period period){
        return serv.create(period);
    }
    @PostMapping("add/course/{courseId}/{locationId}")
    public ResponseEntity<?> addCourse(@PathVariable("periodId") Long periodId, @PathVariable("courseId") Long courseId){
        return serv.addCourse(courseId, periodId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Period period,@PathVariable("id") Long id){
        return serv.update(period, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return serv.delete(id);
    }

    public PeriodService getServ() {
        return serv;
    }

    public void setServ(PeriodService serv) {
        this.serv = serv;
    }
}
