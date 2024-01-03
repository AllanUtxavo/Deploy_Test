package com.lore.sio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="course")

public class Course {
   @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 
    private Date date= new Date();
    private String name;
    private String duracao;
   

    @ManyToMany
    @JoinColumn(name="locations", nullable=false)
    private List<Location> locations;
    
   @ManyToMany
    @JoinColumn(name="periods", nullable=false)
    private List<Period> periods;

    @JsonIgnore
    @ManyToMany (mappedBy = "courses")
    private List<Enrollment> enrollments;

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
    public List<Period> getPeriods() {
    return periods;
}
    public void setPeriods(List<Period> periods) {
    this.periods = periods;
}
    public List<Location> getLocations() {
        return locations;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    public Long getId() {
    return id;
}
    public void setId(Long id) {
    this.id = id;
}

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    
public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
  
    
    
}
