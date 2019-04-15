package com.clouway;

import java.io.Serializable;

public class Dog implements Serializable, AutoCast {
    private String name;
    private int age;
    private String breed;

    public Dog() {
    }
    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public String getBreed() {return breed;}

    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setBreed(String breed) {this.breed = breed;}

    @Override
    public void setAttributesWithAutoCast(Object newClass) {
        if(newClass.getClass().isInstance(this)) {
            Dog castedDog = (Dog) newClass;
            this.name = castedDog.getName();
            this.age = castedDog.getAge();
            this.breed = castedDog.getBreed();
        }
    }
}
