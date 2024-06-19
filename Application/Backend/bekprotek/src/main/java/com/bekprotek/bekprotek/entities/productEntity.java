package com.bekprotek.bekprotek.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;


@Entity
@Table(name="products")
public class productEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String desc;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "product_customization", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "customization_id"))
    private Set<customizationEntity> customization = new HashSet<>();


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


    public Set<customizationEntity> getCustomizations() {
        return customization;
    }

/*    public void setCustomizations(Set<customizationEntity> customization) {
        this.customization = customization;
    }*/



    public productEntity() {}

    public productEntity(String name, String desc) {
        this.name = name;
        this.desc = desc;
/*        this.customization = new HashSet<customizationEntity>();*/
    }
}
