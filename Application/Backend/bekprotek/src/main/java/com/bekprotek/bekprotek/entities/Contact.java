package com.bekprotek.bekprotek.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="test")
public class Contact implements Serializable {
    @Id
    @Column(name = "id")
    private long id; // Change the type to String

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    // Getters and setters for id, name, and phone
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
