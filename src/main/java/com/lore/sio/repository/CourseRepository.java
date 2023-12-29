package com.lore.sio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lore.sio.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {
    
}

