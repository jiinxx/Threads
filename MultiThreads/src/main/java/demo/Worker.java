package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Worker {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void doWork() {
        Thread t1 = new Thread(() -> process());
        Thread t2 = new Thread(() -> process());
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time taken " + (System.currentTimeMillis() -  start));
        System.out.println(list1.size() + " : " + list2.size());
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }



    private void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock1){
         list1.add(random.nextInt());
        }
    }

    private void stageTwo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock2){
            list2.add(random.nextInt());
        }
    }
}
