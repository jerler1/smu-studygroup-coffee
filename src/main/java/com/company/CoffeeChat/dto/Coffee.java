package com.company.CoffeeChat.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
    private String type;
    private Integer roasterId;

    public Coffee() {}

    public Coffee(Integer id, String name, String type, Integer roasterId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.roasterId = roasterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(Integer roasterId) {
        this.roasterId = roasterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) && Objects.equals(name, coffee.name) && Objects.equals(type, coffee.type) && Objects.equals(roasterId, coffee.roasterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, roasterId);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", roasterId=" + roasterId +
                '}';
    }
}
