package ir.sleepycat.springdesignpatterns;

import ir.sleepycat.springdesignpatterns.designpatterns.singleton.ClassicSingleton;
import ir.sleepycat.springdesignpatterns.designpatterns.singleton.Singleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDesignPatternsApplicationTests {

    @Autowired
    Singleton singleton1;

    @Autowired
    Singleton singleton2;

    @Test
    public void testSingletons() {
        ClassicSingleton classicSingleton1 = ClassicSingleton.getInstance();
        ClassicSingleton classicSingleton2 = ClassicSingleton.getInstance();
        Assertions.assertNotNull(classicSingleton1);
        Assertions.assertSame(classicSingleton1, classicSingleton2);
        Assertions.assertNotNull(singleton1);
        Assertions.assertSame(singleton1, singleton2);
    }

}
