import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-12 10:41
 * @create: 2018-12-12 10:41
 **/
public class DynamicProxyTest {
    interface IHello {
        void sayHello(String s);
    }

    static class Hello implements IHello {
        public void sayHello(String s) {
            System.out.println("hello" + s);
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Hello hello = new Hello();
        IHello myHello = (IHello) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                hello.getClass().getInterfaces(), (proxy, method, args1) -> {
                    System.out.println("welcome");
                    return method.invoke(hello,args1);
                });
        myHello.sayHello("world");
    }
}
