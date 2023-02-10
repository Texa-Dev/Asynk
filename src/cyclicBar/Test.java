package cyclicBar;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);

        new Thread(() -> {
            try {

                barrier.await();
                System.out.println("Thread 1 done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                new Thread(() -> {
                    System.out.println("Thread 1 done");
                });
                barrier.await();
                System.out.println("Thread 2 done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
