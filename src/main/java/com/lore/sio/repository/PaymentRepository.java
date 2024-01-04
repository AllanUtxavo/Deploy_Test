package com.lore.sio.repository;
import com.lore.sio.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment,Long> {

    
}
