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

    @PostMapping("/{studentId}/{locationId}/{periodId}/{course01Id}/{course02Id}")
    public ResponseEntity<?> create(@RequestBody Enrollment enrollment, @PathVariable("course01Id") Long course01Id,
     @PathVariable("course02Id") Long course02Id, @PathVariable("periodId") Long periodId, @PathVariable("locationId") Long locationId,
      @PathVariable("studentId") Long studentId){
        return serv.create(enrollment, studentId, locationId, periodId, course01Id, course02Id );
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
