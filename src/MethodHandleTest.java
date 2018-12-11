import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-11 15:43
 * @create: 2018-12-11 15:43
 **/
public class MethodHandleTest {
    static class A{
        void println(String s){
            System.out.println("A:" + s);
        }
    }

    private static MethodHandle getPrintln(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
    public static void main(String[] args) throws Throwable {
        Object object = Math.random() > 0.5 ? System.out : new A();
        getPrintln(object).invokeExact("test");

        Method method = A.class.getMethod("println", String.class);
        method.invoke(new A(), "a");
    }
}
