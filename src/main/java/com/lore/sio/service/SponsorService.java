package com.lore.sio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lore.sio.repository.SponsorRepository;
import com.lore.sio.repository.StudentRepository;
import com.lore.sio.model.Sponsor;
import com.lore.sio.model.Student;

import java.util.List;
import java.util.Optional;

import com.lore.sio.config.Message;
@Service
public class SponsorService {

    @Autowired
    private SponsorRepository rep;

    @Autowired
    private StudentRepository studentRep;

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
        List<Sponsor> sponsors=rep.findAll();
        if(sponsors.size()<=0){
            msg.setMessage("Nenhum encarregado achado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sponsors,HttpStatus.OK);
    }

    public ResponseEntity<?> create(Sponsor sponsor){
        return new ResponseEntity<>(rep.save(sponsor),HttpStatus.OK);
    }

    public ResponseEntity<?> addStudent(Long sponsor_id, Long student_id){
        Optional <Sponsor> sponsor = rep.findById(sponsor_id);
        Optional <Student> student = studentRep.findById(student_id);
        if(!sponsor.isPresent()){
            msg.setMessage("O encarregado indicado nao existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        } else if(!student.isPresent()){
            msg.setMessage("O estudante indicado nao existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        } 
        Student std=student.get();
        Sponsor sps=sponsor.get();
        if(!sps.getStudents().contains(std))sps.getStudents().add(std);
        if(!std.getSponsors().contains(sps))std.getSponsors().add(sps);
        studentRep.save(std);
        rep.save(sps);
        msg.setMessage("Estudante associado com sucesso");
        return new ResponseEntity<>(msg,HttpStatus.OK);

    }

    public ResponseEntity<?> update(Sponsor sponsor,Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        sponsor.setId(id);
        return new ResponseEntity<>(rep.save(sponsor),HttpStatus.OK);
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
