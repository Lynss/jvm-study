/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-13 15:47
 * @create: 2018-12-13 15:47
 **/
public class VolatileTest {
    private static volatile int race = 0;
    private static synchronized void increase(){
        race++;//non-atomic operation
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
