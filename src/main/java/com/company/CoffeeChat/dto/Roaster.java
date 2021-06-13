package com.company.CoffeeChat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="roaster")
public class Roaster {

    private Integer id;
    private String name;
    private String city;
    private String state;

    @OneToMany(mappedBy = "roasterId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Coffee> coffees;

    public Roaster(Integer id, String name, String city, String state, Set<Coffee> coffees) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.coffees = coffees;
    }

    public Roaster() {}

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Set<Coffee> coffees) {
        this.coffees = coffees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return Objects.equals(id, roaster.id) && Objects.equals(name, roaster.name) && Objects.equals(city, roaster.city) && Objects.equals(state, roaster.state) && Objects.equals(coffees, roaster.coffees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, state, coffees);
    }

    @Override
    public String toString() {
        return "Roaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", coffees=" + coffees +
                '}';
    }
}
