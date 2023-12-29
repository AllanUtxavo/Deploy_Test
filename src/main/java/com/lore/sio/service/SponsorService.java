package com.lore.sio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lore.sio.repository.SponsorRepository;
import com.lore.sio.model.Sponsor;
import java.util.List;
import com.lore.sio.config.Message;
@Service
public class SponsorService {

    @Autowired
    private SponsorRepository rep;

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
