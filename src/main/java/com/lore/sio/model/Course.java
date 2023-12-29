package com.lore.sio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")

public class Course {
   @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 
    private String course_01;
    private String course_02;
    private String duracao;

    public Long getId() {
    return id;
}
    public void setId(Long id) {
    this.id = id;
}

    public String getCourse_01() {
        return course_01;
    }
    public void setCourse_01(String course_01) {
        this.course_01 = course_01;
    }
  
    public String getCourse_02() {
        return course_02;
    }
    public void setCourse_02(String course_02) {
        this.course_02 = course_02;
    }
 
    
    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
  
    
    
}
