package waitAwait;

import muteks.Source;

import java.util.concurrent.TimeUnit;

public class Manager extends  Thread {
    private final Source source;

    public Manager(Source source) {
        this.source = source;
    }

    @Override
    public void run() {

            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2000);
                    synchronized (source) {
                        source.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
