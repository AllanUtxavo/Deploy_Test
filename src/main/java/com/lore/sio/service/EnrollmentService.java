package com.lore.sio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lore.sio.repository.EnrollmentRepository;
import com.lore.sio.model.Enrollment;
import java.util.List;
import com.lore.sio.config.Message;
@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository rep;

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

    public ResponseEntity<?> create(Enrollment enrollment){
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
