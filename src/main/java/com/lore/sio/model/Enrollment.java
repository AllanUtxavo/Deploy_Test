package com.lore.sio.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date date= new Date();
    
    @ManyToMany
    @JoinColumn(name="enrollments")
    private List<Course> courses;
 
    @ManyToOne
    @JoinColumn(name="period_id")
    private Period period;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

      public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
  

   

    public void setPeriod(Period period) {
        this.period = period;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

  

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Date getDate(){
        return  date;
    }

    public void setDate(Date date){
        this.date=date;
    }
    
}
