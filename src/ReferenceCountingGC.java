/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-04 15:37
 * @create: 2018-12-04 15:37
 * -XX:+PrintGCDetails -Xms10M -Xmx10M
 **/
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;
        //由于他们互相引用，导致未能被回收
        System.gc();
    }
}
