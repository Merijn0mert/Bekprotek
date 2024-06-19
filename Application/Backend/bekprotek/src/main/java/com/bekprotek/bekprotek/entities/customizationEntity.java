package com.bekprotek.bekprotek.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "customizations")
public class customizationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customization_id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desc;
    @ManyToMany(mappedBy = "customization")
    @JsonIgnore
    private Set<productEntity> products;


    // Getters and setters for id, name, and description
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    /*@JsonIgnore*/
    public Set<productEntity> getProducts() {
        return products;
    }

/*    public void setProducts(Set<productEntity> products) {
        this.products = products;
    }*/


    public customizationEntity() {}

    public customizationEntity(String name, String desc) {
        this.name = name;
        this.desc = desc;
/*        this.products = new HashSet<productEntity>();*/
    }
}
