import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static AtomicInteger race = new AtomicInteger(0);
    private static void increase() {
        // cas also may cause ABA problem see the AtomicStampedReference
        race.incrementAndGet();
    }

    public static void main(String[] args) {
        int beforeActive = Thread.activeCount();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }).start();
        }
        while (Thread.activeCount() > beforeActive) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
