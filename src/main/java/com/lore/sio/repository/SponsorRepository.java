package com.lore.sio.repository;

import com.lore.sio.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    
}
