package StopThread;

public class testStop {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(5000);
        System.out.println("End");
        myThread.interrupt();
        //if (myThread.isAlive()){
        //   myThread.stop();
        // myThread.stopThis();

    }
}
