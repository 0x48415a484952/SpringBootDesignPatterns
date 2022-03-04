package ir.sleepycat.springdesignpatterns.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;

@AllArgsConstructor
@Getter
public enum Animal {

    DOG("dog", "bark", "mammal"),
    CAT("cat", "meow", "mammal");

    private final String type;
    private final String sound;
    private final String group;

    public static Animal fromString(String type) {
        for (Animal animal : Animal.values()) {
            if (animal.type.equalsIgnoreCase(type.toUpperCase(Locale.ROOT))) {
                return animal;
            }
        }
        return null;
    }
}
