package com.lore.sio.model;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private String tel1;
    private String tel2;
    private String address;
    private String email;
    private String nacionality;
    private String gender;
    private String province;

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
<<<<<<< HEAD
=======

>>>>>>> 9b03868fc046e1121529b87e6b009a5ded42dc24
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

}
