package StopThread;

public class MyThread extends Thread {

    private volatile boolean cont = true;
public void stopThis(){
    cont=false;
    interrupt();
}
    @Override
    public void run() {
        for (int i = 0; cont && i < Integer.MAX_VALUE; i++) {
            System.out.println("Some work: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
