package concurency;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            // ...
            Thread.sleep(10000l);
            return "Hello world";
        });

        try {
            System.out.println(future.get(11, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
