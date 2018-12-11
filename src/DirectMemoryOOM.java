import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-04 15:29
 * @create: 2018-12-04 15:29
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 **/
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
