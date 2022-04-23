package ir.sleepycat.springdesignpatterns.designpatterns.factory;


import ir.sleepycat.springdesignpatterns.enumeration.Animal;

public interface Pet {
    String makeSound();
    void setName(String name);
    String getName();
    Animal getAnimal();
}
