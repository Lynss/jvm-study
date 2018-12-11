/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-11 14:33
 * @create: 2018-12-11 14:33
 **/
public class StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {
    }

    public void sayHello(Human human) {
        System.out.println("hi,guys");
    }

    public void sayHello(Man man) {
        System.out.println("hi,man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hi,woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }
}
