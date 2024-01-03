package com.lore.sio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lore.sio.repository.CourseRepository;
import com.lore.sio.repository.LocationRepository;
import com.lore.sio.repository.PeriodRepository;
import com.lore.sio.model.Course;
import com.lore.sio.model.Location;
import com.lore.sio.model.Period;

import java.util.List;
import java.util.Optional;


import com.lore.sio.config.Message;

@Service
public class CourseService {

    @Autowired
    private CourseRepository rep;
    @Autowired
    private LocationRepository locationRep;
     @Autowired
    private PeriodRepository periodRep;
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
        List<Course> courses=rep.findAll();
        if(courses.size()<=0){
            msg.setMessage("Nenhum curso achado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    public ResponseEntity<?> create(Course course){
        return new ResponseEntity<>(rep.save(course),HttpStatus.OK);
    }

    public ResponseEntity<?> addLocation(Long courseId, Long locationId){
        Optional<Course> course=rep.findById(courseId);
        Optional<Location> location=locationRep.findById(locationId);
        if(!course.isPresent()){
            msg.setMessage("A conta de estudante indicada não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }else if(!location.isPresent()){
            msg.setMessage("A conta de encarregado indicada não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
        Course crs=course.get();
        Location lct=location.get();
        if(!lct.getCourses().contains(crs))lct.getCourses().add(crs);
        if(!crs.getLocations().contains(lct))crs.getLocations().add(lct);
        locationRep.save(lct);
        rep.save(crs);
        msg.setMessage("Local adicionado com sucesso");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    public ResponseEntity<?> addPeriod(Long courseId, Long periodId){
        Optional<Course> course=rep.findById(courseId);
        Optional<Period> period=periodRep.findById(periodId);
        if(!course.isPresent()){
            msg.setMessage("A conta de estudante indicada não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }else if(!period.isPresent()){
            msg.setMessage("A conta de encarregado indicada não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
        Course crs=course.get();
        Period prd=period.get();
        if(!prd.getCourses().contains(crs))prd.getCourses().add(crs);
        if(!crs.getPeriods().contains(prd))crs.getPeriods().add(prd);
        periodRep.save(prd);
        rep.save(crs);
        msg.setMessage("Periodo adicionado com sucesso!");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
  public ResponseEntity<?> update(Course course,Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        course.setId(id);
        return new ResponseEntity<>(rep.save(course),HttpStatus.OK);
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