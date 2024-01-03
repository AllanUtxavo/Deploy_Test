package com.lore.sio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lore.sio.repository.CourseRepository;
import com.lore.sio.repository.EnrollmentRepository;
import com.lore.sio.repository.LocationRepository;
import com.lore.sio.repository.PeriodRepository;
import com.lore.sio.repository.StudentRepository;
import com.lore.sio.model.Course;
import com.lore.sio.model.Enrollment;
import com.lore.sio.model.Location;
import com.lore.sio.model.Period;
import com.lore.sio.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lore.sio.config.Message;
@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository rep;
    @Autowired
    private StudentRepository studentRep;
    @Autowired
    private LocationRepository locationRep;
    @Autowired
    private PeriodRepository periodRep;
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
        List<Enrollment> enrollments=rep.findAll();
        if(enrollments.size()<=0){
            msg.setMessage("Nenhuma pre-inscrição achada");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(enrollments,HttpStatus.OK);
    }

    public ResponseEntity<?> create(Enrollment enrollment, Long studentId, Long locationId, Long periodId, Long course01Id, Long course02Id){
       Optional<Student> student = studentRep.findById(studentId);
       if(!student.isPresent()){
        msg.setMessage("O estudante nao existe");
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
       }
       Optional<Location> location = locationRep.findById(locationId);
       if(!location.isPresent()){
        msg.setMessage("A localizacao nao existe");
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
       }
       Optional<Period> period = periodRep.findById(periodId);
       if(!period.isPresent()){
        msg.setMessage("O periodo nao existe");
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
       }
        Optional<Course> course01 = courseRep.findById(course01Id);
       if(!course01.isPresent()){
        msg.setMessage("O curso nao existe");
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
       }
       Optional<Course> course02 = courseRep.findById(course02Id);
       if(!course02.isPresent()){
        msg.setMessage("O curso nao existe");
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
       }
        enrollment.setStudent(student.get());
        enrollment.setLocation(location.get());
        enrollment.setPeriod(period.get());
        List<Course> courses=new ArrayList <Course>();
        courses.add(course01.get());
        courses.add(course02.get());
        enrollment.setCourses(courses);

        return new ResponseEntity<>(rep.save(enrollment),HttpStatus.OK);
    }

    public ResponseEntity<?> update(Enrollment enrollment,Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        enrollment.setId(id);
        return new ResponseEntity<>(rep.save(enrollment),HttpStatus.OK);
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
