package demo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable {
    private final int id;

    public Process(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println(Thread.currentThread().getId() + " starting job #" + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " finishing job #" + id);

    }
}

public class App {

    public static void main(String[] args) {
        new App().doWork();
    }

    private void doWork() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executor.execute(new Process(i));
        }
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
