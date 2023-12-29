package com.lore.sio.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Table(name="enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String course;
    private String period;
    private String location;
    private Date date;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course=course;
    }

    public String getPeriod(){
        return period;
    }

    public void setPeriod(String period){
        this.period=period;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public Date getDate(){
        return  date;
    }

    public void setDate(Date date){
        this.date=date;
    }
    
}
