package com.lore.sio.repository;

import com.lore.sio.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    boolean existsByTel1(String Tel1);
    boolean existsByTel2(String Tel2);
}
