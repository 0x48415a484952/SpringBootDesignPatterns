package ir.sleepycat.springdesignpatterns.designpatterns.factory;

import ir.sleepycat.springdesignpatterns.enumeration.Animal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat implements Pet {

    private String name;
    private final String type = getAnimal().getType();
    private final String sound = getAnimal().getSound();
    private final String group = getAnimal().getGroup();

    @Override
    public String makeSound() {
        return this.sound;
    }

    @Override
    public Animal getAnimal() {
        return Animal.CAT;
    }

}
