package com.lore.sio.service;

import java.util.Date;
import java.util.Optional;

import com.lore.sio.config.Message;
import com.lore.sio.model.Payment;
import com.lore.sio.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    @Autowired
    private PaymentRepository rep;

    @Autowired
    protected Message msg;
    
     public ResponseEntity<?> list(Long id){
        if(!rep.existsById(id)){
            msg.setMessage("Pagamento não encontrado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rep.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<?> list(){
        if(rep.count()<=0) {
            msg.setMessage("Nenhum pagamento encontrado");
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rep.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> create(Payment payment){
        if(payment.getDebtValue()==0){
            payment.setEndOfPayment(new Date());
        }
        return new ResponseEntity<>(rep.save(payment),HttpStatus.OK);
    }

    public ResponseEntity<?> update(Payment payment,Long id){
        Optional<Payment> pay=rep.findById(id);
        if(!pay.isPresent()){
            msg.setMessage("O pagamento indicado pelo id "+id+" não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
        payment.setId(id);
        payment.setCreationDate(pay.get().getCreationDate());
        if(payment.getDebtValue()==0 && payment.getEndOfPayment()==null){
            payment.setEndOfPayment(new Date());
        }
        return new ResponseEntity<>(rep.save(payment),HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id){
        if(!rep.existsById(id)){
            msg.setMessage("O pagamento indicado pelo id "+id+" não existe");
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
        rep.deleteById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
