package ir.sleepycat.springdesignpatterns.designpatterns.singleton;

public class ClassicSingleton {

    private static ClassicSingleton instance;

    private ClassicSingleton() {
        super();
    }

    public static ClassicSingleton getInstance() {
        if (ClassicSingleton.instance == null) {
            synchronized (ClassicSingleton.class) {
                if (ClassicSingleton.instance == null) {
                    instance = new ClassicSingleton();
                }
            }
        }
        return instance;
    }

}
