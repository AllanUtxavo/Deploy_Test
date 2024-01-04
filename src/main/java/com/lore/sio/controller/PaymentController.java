package com.lore.sio.controller;

import com.lore.sio.model.Payment;
import com.lore.sio.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("localhost:3000")
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired 
    private PaymentService serv;

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id") Long id){
      return serv.list(id);
    }

    @GetMapping
    public ResponseEntity<?> list(){
      return serv.list();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Payment payment){
      return serv.create(payment);
    }  

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Payment payment, @PathVariable("id") Long id){

      return serv.update(payment, id);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
      return serv.delete(id);
    }
}
