package org.rosinenhasser.jakarta.cat.dto;

public class CreateCatDto {
    private String name;
    private String species;
    private int age;
    private boolean isVegan;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getIsVegan() {
        return isVegan;
    }
    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }
}
