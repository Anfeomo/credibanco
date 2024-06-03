package com.nexus.credibanco.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name="last_name", nullable = false, length = 100)
    private String lastName;
    @Column(name = "registration_date")
    private Date registrationDate;



    public Client() {

    }

    public Client(Long id, String name, String lastName, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }




}
