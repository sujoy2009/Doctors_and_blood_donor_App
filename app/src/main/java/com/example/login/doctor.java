package com.example.login;

public class doctor {
 String name,hospital_name,location,contact,catagory,about,all,id,pin,bmdc;

 public  doctor(){

 }

    public doctor(String id,String name, String hospital_name, String location, String contact, String catagory,String about,String all,String pin,String bmdc) {
        this.name = name;
        this.hospital_name = hospital_name;
        this.location = location;
        this.contact = contact;
        this.catagory = catagory;
        this.about=about;
        this.all=all;
        this.id=id;
        this.pin=pin;
        this.bmdc=bmdc;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setLocation(String location) {
        this.location = location;
    }



    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBmdc(String bmdc) {
        this.bmdc = bmdc;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public String getCatagory() {
        return catagory;
    }

    public String getAbout() {
        return about;
    }

    public String getAll() {
        return all;
    }

    public String getPin() {
        return pin;
    }

    public String getBmdc() {
        return bmdc;
    }
}
