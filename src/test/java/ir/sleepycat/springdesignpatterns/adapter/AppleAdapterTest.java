package ir.sleepycat.springdesignpatterns.adapter;

import ir.sleepycat.springdesignpatterns.designpatterns.adapter.Apple;
import ir.sleepycat.springdesignpatterns.designpatterns.adapter.AppleAdapter;
import ir.sleepycat.springdesignpatterns.designpatterns.adapter.MoroOrange;
import ir.sleepycat.springdesignpatterns.designpatterns.adapter.Orange;
import org.junit.jupiter.api.Test;

class AppleAdapterTest {
    @Test
    void testAdapter() {
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVariety());
        apple.eat();
    }
}
