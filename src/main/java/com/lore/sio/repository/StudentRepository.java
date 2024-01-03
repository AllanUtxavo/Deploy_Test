package com.lore.sio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lore.sio.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
    boolean existsByTel1(String Tel1);
    boolean existsByTel2(String Tel2);
    boolean existsByEmail(String email);

}
