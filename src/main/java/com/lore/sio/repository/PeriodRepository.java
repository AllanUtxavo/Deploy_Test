package com.lore.sio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lore.sio.model.Period;

public interface PeriodRepository extends JpaRepository<Period, Long>  {
    
}

