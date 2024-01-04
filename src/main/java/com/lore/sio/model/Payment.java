package com.lore.sio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double payedValue=0;
    private double debtValue=0;
    private String type;
    private String reference;
    private String description;



    @JsonIgnore
    @OneToOne(mappedBy = "payment")
    private Enrollment enrollment;

    private Date creationDate=new Date();

    private Date endOfPayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPayedValue() {
        return payedValue;
    }

    public void setPayedValue(double payedValue) {
        this.payedValue = payedValue;
    }

    public double getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(double debtValue) {
        this.debtValue = debtValue;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndOfPayment() {
        return endOfPayment;
    }

    public void setEndOfPayment(Date endOfPayment) {
        this.endOfPayment = endOfPayment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
