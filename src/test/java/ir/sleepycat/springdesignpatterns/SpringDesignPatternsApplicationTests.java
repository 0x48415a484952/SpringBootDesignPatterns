package ir.sleepycat.springdesignpatterns;

import ir.sleepycat.springdesignpatterns.designpatterns.prototype.ProtoFalse;
import ir.sleepycat.springdesignpatterns.designpatterns.prototype.ProtoTrue;
import ir.sleepycat.springdesignpatterns.designpatterns.repository.PresidentRepository;
import ir.sleepycat.springdesignpatterns.designpatterns.singleton.ClassicSingleton;
import ir.sleepycat.springdesignpatterns.designpatterns.singleton.Singleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDesignPatternsApplicationTests {
    ///////Singleton Tests/////////
    @Autowired
    Singleton singleton1;
    @Autowired
    Singleton singleton2;

    @Autowired
    PresidentRepository presidentRepository;

    @Test
    void testRepository() {
        System.out.println(presidentRepository.findById(1L));
        System.out.println(presidentRepository.findById(2L));
    }

    @Test
    void testSingletons() {
        ClassicSingleton classicSingleton1 = ClassicSingleton.getInstance();
        ClassicSingleton classicSingleton2 = ClassicSingleton.getInstance();
        Assertions.assertNotNull(classicSingleton1);
        Assertions.assertSame(classicSingleton1, classicSingleton2);
        Assertions.assertNotNull(singleton1);
        Assertions.assertSame(singleton1, singleton2);
    }

    ///////Prototype Tests/////////
    @Autowired
    ProtoTrue protoTrue1;
    @Autowired
    ProtoTrue protoTrue2;
    @Autowired
    ProtoFalse protoFalse1;
    @Autowired
    ProtoFalse protoFalse2;

    @Test
    void testPrototypes() {
        Assertions.assertSame(protoFalse1, protoFalse2);
        Assertions.assertNotSame(protoTrue1, protoTrue2);
    }
}
