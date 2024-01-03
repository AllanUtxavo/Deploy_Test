package com.lore.sio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lore.sio.config.Message;
import com.lore.sio.model.Location;
import com.lore.sio.model.Course;
import com.lore.sio.repository.CourseRepository;
import com.lore.sio.repository.LocationRepository;


@Service
public class LocationService {
    @Autowired
    private LocationRepository rep;
     @Autowired
    private CourseRepository courseRep;

    @Autowired
    private Message msg;
    public ResponseEntity<?> list(Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rep.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<?> list(){
        List<Location> locations=rep.findAll();
        if(locations.size()<=0){
            msg.setMessage("Nenhum local foi achado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locations,HttpStatus.OK);
    }

   
    public ResponseEntity<?> create(Location location){
        return new ResponseEntity<>(rep.save(location),HttpStatus.OK);
    }

    public ResponseEntity<?> addCourse(Long courseId, Long locationId){
        Optional<Course> course=courseRep.findById(courseId);
        Optional<Location> location=rep.findById(locationId);
        if(!course.isPresent()){
            msg.setMessage("O curso indicado não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }else if(!location.isPresent()){
            msg.setMessage("A localizacao indicada não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
        Course crs=course.get();
        Location lct=location.get();
        if(!lct.getCourses().contains(crs))lct.getCourses().add(crs);
        if(!crs.getLocations().contains(lct))crs.getLocations().add(lct);
        courseRep.save(crs);
        rep.save(lct);
        msg.setMessage("curso associado com sucesso");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

  public ResponseEntity<?> update(Location location,Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        location.setId(id);
        msg.setMessage("Localização actulizada com sucesso!");
        return new ResponseEntity<>(rep.save(location),HttpStatus.OK);
    }
    
    public ResponseEntity<?> delete(Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        rep.deleteById(id);
        msg.setMessage("Deletado com sucesso");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
