/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-11 14:57
 * @create: 2018-12-11 14:57
 * so we call "动态单分派" “静态多分派”
 **/
public class Dispatch {
    static class QQ {

    }

    static class _360 {

    }

    static class Father {
        protected void hardChoice(_360 _3) {
            System.out.println("father 360");
        }
        protected void hardChoice(QQ qq) {
            System.out.println("father qq");
        }
    }

    static class Son extends Father {
//        @Override
//        protected void hardChoice(_360 _3) {
//            System.out.println("son 360");
//        }

        @Override
        protected void hardChoice(QQ qq) {
            System.out.println("son qq");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new QQ());
        son.hardChoice(new _360());//father 360 because it can't find a hardChoice method whose parameter type is _360 in class Son
    }
}
