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

import com.lore.sio.model.Location;
import com.lore.sio.service.LocationService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService serv;

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
        return serv.list(id);
    } 

    @GetMapping
    public ResponseEntity<?> list(){
        return serv.list();
    }
        @PostMapping
    public ResponseEntity<?> create(@RequestBody Location location){
        return serv.create(location);
    }
    @PostMapping("add/course/{courseId}/{locationId}")
   public ResponseEntity<?> addCourse(@PathVariable("locationId") Long locationId, @PathVariable("courseId") Long courseId){
        return serv.addCourse(courseId, locationId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Location location,@PathVariable("id") Long id){
        return serv.update(location, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return serv.delete(id);
    }
}
