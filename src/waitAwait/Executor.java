package waitAwait;

import muteks.Source;

public class Executor extends Thread {
    private final Source source;

    public Executor(Source source) {
        this.source = source;
    }

    @Override
    public void run() {
        synchronized (source) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    source.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
