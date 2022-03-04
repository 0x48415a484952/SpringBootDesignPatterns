package ir.sleepycat.springdesignpatterns.designpatterns.factory;

import ir.sleepycat.springdesignpatterns.enumeration.Animal;
import ir.sleepycat.springdesignpatterns.exceptions.AnimalNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class PetFactory {

    public Pet createPet(Animal animalType) {
        switch (animalType) {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            default:
                throw new AnimalNotFoundException();
        }

    }

}
