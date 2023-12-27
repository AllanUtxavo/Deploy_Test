package com.lore.sio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lore.sio.repository.StudentRepository;
import com.lore.sio.model.Student;
import java.util.List;
import com.lore.sio.config.Message;

@Service
public class StudentService {

    @Autowired
    private StudentRepository rep;

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
        List<Student> students=rep.findAll();
        if(students.size()<=0){
            msg.setMessage("Nenhum estudante achado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    public ResponseEntity<?> create(Student student){
        return new ResponseEntity<>(rep.save(student),HttpStatus.OK);
    }

    public ResponseEntity<?> update(Student student,Long id){
        return new ResponseEntity<>("",HttpStatus.OK);
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
