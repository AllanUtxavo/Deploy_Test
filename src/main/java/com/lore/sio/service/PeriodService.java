package com.lore.sio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lore.sio.config.Message;
import com.lore.sio.model.Course;
import com.lore.sio.model.Period;
import com.lore.sio.repository.CourseRepository;
import com.lore.sio.repository.PeriodRepository;


@Service
public class PeriodService {
    @Autowired
    private PeriodRepository rep;
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
        List<Period> periods=rep.findAll();
        if(periods.size()<=0){
            msg.setMessage("Nenhum periodo foi achado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(periods,HttpStatus.OK);
    }

   
    public ResponseEntity<?> create(Period period){
        return new ResponseEntity<>(rep.save(period),HttpStatus.OK);
    }
     public ResponseEntity<?> addCourse(Long courseId, Long periodId){
        Optional<Course> course=courseRep.findById(courseId);
        Optional<Period> period=rep.findById(periodId);
        if(!course.isPresent()){
            msg.setMessage("O curso indicado não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }else if(!period.isPresent()){
            msg.setMessage("A localizacao indicada não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
        Course crs=course.get();
        Period prd=period.get();
        if(!prd.getCourses().contains(crs))prd.getCourses().add(crs);
        if(!crs.getPeriods().contains(prd))crs.getPeriods().add(prd);
        courseRep.save(crs);
        rep.save(prd);
        msg.setMessage("curso associado com sucesso");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
  public ResponseEntity<?> update(Period period,Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        period.setId(id);
        msg.setMessage("Periodo actualizado com sucesso");
        return new ResponseEntity<>(rep.save(period),HttpStatus.OK);
    }
    
    public ResponseEntity<?> delete(Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        rep.deleteById(id);
        msg.setMessage("Periodo deletado com sucesso");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
