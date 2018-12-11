/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-11 14:46
 * @create: 2018-12-11 14:46
 **/
public class DynamicDispatch {
    static abstract class Human {
        protected void sayHello() {
            System.out.println("hi,guy");
        }
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("hi,man");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("hi,woman");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
