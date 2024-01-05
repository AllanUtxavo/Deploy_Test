package com.lore.sio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="students")
public class Student {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String  name;
    private String surname;
    private Date birthday;

    @Column(unique = true, nullable = false)
    private String tel1;

    private String tel2;

    private String address;

    private String email;

    private String nacionality;
    private String gender;
    private String province;
    private String desease;
    private String degree;
    private Date date= new Date();

    @JsonIgnore
    @OneToMany(mappedBy="student")
    private List<Enrollment> enrollments;

    @JsonIgnore
    @ManyToMany (mappedBy="students")
    private List<Sponsor> sponsors;
    
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getNacionality() {
        return nacionality;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public Date getBirthday(){
        return birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday=birthday;
    }

    public String getTel1(){
        return tel1;
    }

    public void setTel1(String tel1){
        this.tel1=tel1;
    }

    public String getTel2(){
        return tel2;
    }

    public void setTel2(String tel2){
        this.tel2=tel2;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getDesease() {
        return desease;
    }

    public void setDesease(String desease) {
        this.desease = desease;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    

}
