package com.lore.sio.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="enrollments")
public class Enrollment {
    @Transient
    private final String STATUS_ONE="ACTIVA";
    
    @Transient
    private final String STATUS_TWO="PENDENTE";

    @Transient
    private final String STATUS_THRE="CANCELADA";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String status = STATUS_TWO;
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


    @OneToOne
    @JoinColumn(name="payment_id")
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Period getPeriod() {
        return period;
    }

    public Location getLocation() {
        return location;
    }

    
    
}
