package feature;

import waitAwait.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        try(ExecutorService service= Executors.newSingleThreadExecutor()){
            FutureTask<String> fTask = new FutureTask<>(() -> {
                String s = "";
                for (int i = 0; i < 10; i++) {
                    s = s + i;
                    TimeUnit.SECONDS.sleep(1);
                }
                return s;
            });
            //  service.submit(fTask);
              service.execute(fTask);
            System.out.println("Execute");
              while (!fTask.isDone()){
                  TimeUnit.SECONDS.sleep(1);
                  System.out.println(fTask.get());
              }
            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
