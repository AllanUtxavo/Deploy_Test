package com.lore.sio.repository;

import com.lore.sio.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{
    
}
