package org.rosinenhasser.jakarta.cat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat")
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "age")
    private int age;

    @Column(name = "isVegan")
    private boolean isVegan;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() { return species; }
    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsVegan() { return isVegan; }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }
    
    @Override
    public String toString() {
        return "\n{\n name: \"" + this.getName() + "\",\n species: \"" + this.getSpecies() + "\",\n age: " + this.getAge()
                + ",\n isVegan: " + this.getIsVegan() + "\n}";
    }
}
