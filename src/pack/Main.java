package pack;

public class Main {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("start");
     // new MyThread().start();
        System.out.println("end");

        Thread thread1 = new Thread(() -> {
            System.out.println("Start thread");
            try {
                Thread.sleep(3000);
                System.out.println( Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End thread");
        });
        thread1.setPriority(1);
        thread1.setName("WTF");
        thread1.start();
    }
}