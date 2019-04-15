package com.clouway;

import java.io.Serializable;

public class Person implements Serializable,AutoCast {
    private String name;
    private int age;
    private boolean married;

    public Person() {
    }
    public Person(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public boolean isMarried() {return married;}

    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setMarried(boolean married) {this.married = married;}

    @Override
    public void setAttributesWithAutoCast(Object newClass) {
        if(newClass.getClass().isInstance(this)) {
            Person newPerson = (Person) newClass;

            this.name = newPerson.getName();
            this.age = newPerson.getAge();
            this.married = newPerson.isMarried();
        }
    }
}
