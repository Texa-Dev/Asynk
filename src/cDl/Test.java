package cDl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

      new Thread(() -> {
          try {
              latch.countDown();latch.countDown();
              latch.await();
              System.out.println("Thread 1 done");
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                new Thread(() -> {
                    try {
                        latch.await();
                        System.out.println("Thread 1 done");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                latch.await();
                System.out.println("Thread 2 done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
