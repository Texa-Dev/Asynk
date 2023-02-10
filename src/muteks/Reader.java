package muteks;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Reader extends Thread {
    private final Source resource;

    public Reader(Source resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(resource.val--);
                    SECONDS.sleep(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}