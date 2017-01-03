package demo;

class MyRunnable implements Runnable{

    private final int id;

    public MyRunnable(int i) {
        this.id = i;
    }

    public void run() {
        int counter = 0;
        while (counter++ < 5){
            System.out.println("Hello + " + this.id);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(1));
        Thread t2 = new Thread(new MyRunnable(2));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finished");

    }
}
