package com.lore.sio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lore.sio.config.Message;
import com.lore.sio.model.Period;
import com.lore.sio.repository.PeriodRepository;


@Service
public class PeriodService {
    @Autowired
    private PeriodRepository rep;

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
            msg.setMessage("Nenhum local foi achado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(periods,HttpStatus.OK);
    }

   
    public ResponseEntity<?> create(Period period){
        return new ResponseEntity<>(rep.save(period),HttpStatus.OK);
    }

  public ResponseEntity<?> update(Period period,Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Não existe");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        period.setId(id);
        return new ResponseEntity<>(rep.save(period),HttpStatus.OK);
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
