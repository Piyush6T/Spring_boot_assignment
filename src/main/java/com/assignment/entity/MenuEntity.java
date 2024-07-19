package com.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Lob;



@Entity
public class MenuEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jsonModel;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJsonModel() {
        return jsonModel;
    }

    public void setJsonModel(String jsonModel) {
        this.jsonModel = jsonModel;
    }
}

