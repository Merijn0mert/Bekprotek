package com.bekprotek.bekprotek.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="orders")
public class orderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id; // Change the type to String

    @Column(name = "created_by")
    private long created_by;

    @Column(name = "product_id")
    private long product_id;

    @Column(name = "customization")
    private String customization;

    @Column(name = "description")
    private String description;

    @Column(name = "accepted")
    private boolean accepted;

    // Getters and setters for id, name, and description
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(long created_by) {
        this.created_by = created_by;
    }

    public long getProduct_id() {return product_id;}

    public void setProduct_id(long product_id) {this.product_id = product_id;}

    public String getCustomization() {
        return customization;
    }

    public void setCustomization(String customization) {
        this.customization = customization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccepted() {return accepted;}

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    public orderEntity() {}

    public orderEntity(String customization, String description,long created_by, boolean accepted) {
        this.customization = customization;
        this.created_by = created_by;
        this.customization = customization;
        this.accepted = accepted;
    }
}