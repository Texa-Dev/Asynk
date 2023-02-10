package Lock;

import muteks.Source;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Source source=new Source();
        Condition condition= lock.newCondition();
        Thread thread1=new Thread(() -> {
         lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println("Theard1 "+ source.val++);
            }
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        });
        Thread thread2=new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println("Theard2 "+ source.val++);
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        });
thread2.start();
thread1.start();
    }
}
