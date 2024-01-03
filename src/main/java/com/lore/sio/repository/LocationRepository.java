package com.lore.sio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lore.sio.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>  {
    
}

