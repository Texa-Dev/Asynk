package waitAwait;

import muteks.Source;

public class TestWait  {
    public static void main(String[] args) {
        Source source=new Source();
        Manager manager=new Manager(source);
        Executor executor=new Executor(source);
        executor.start();
        manager.start();
    }
}
