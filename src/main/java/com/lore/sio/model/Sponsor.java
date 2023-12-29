package com.lore.sio.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="sponsors")
public class Sponsor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String tel1;
    private String tel2;
    private String address;


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
}
