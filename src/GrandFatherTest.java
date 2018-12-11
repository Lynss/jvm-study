import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-11 16:16
 * @create: 2018-12-11 16:16
 **/
public class GrandFatherTest {
    static class GrandFather{
        void thinking() {
            System.out.println("g t");
        }
    }
    static class Father extends GrandFather{
        @Override
        void thinking() {
            System.out.println("f t");
        }
    }
    static class Son extends Father{
        @Override
        void thinking() {
            MethodType methodType = MethodType.methodType(void.class);
            try {
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", methodType, Son.class);
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.thinking();//father thinking https://www.zhihu.com/question/40427344
    }
}
