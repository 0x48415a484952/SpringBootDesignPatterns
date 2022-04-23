package ir.sleepycat.springdesignpatterns.decorator;

import ir.sleepycat.springdesignpatterns.designpatterns.decorator.Pepperoni;
import ir.sleepycat.springdesignpatterns.designpatterns.decorator.Pizza;
import ir.sleepycat.springdesignpatterns.designpatterns.decorator.ThickCrustPizza;
import org.junit.jupiter.api.Test;

class DecoratorTest {
    @Test
    void testDecorator() {
        Pizza pizza = new ThickCrustPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        Pepperoni pepperoni = new Pepperoni(pizza);
        System.out.println(pepperoni.getDescription());
        System.out.println(pepperoni.getCost());

        Pepperoni doublePepperoni = new Pepperoni(pepperoni);
        System.out.println(doublePepperoni.getDescription());
        System.out.println(doublePepperoni.getCost());
    }
}
