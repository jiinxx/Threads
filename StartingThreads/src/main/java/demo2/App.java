package demo2;

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
        new MyRunnable(1).run();
        new MyRunnable(2).run();

        System.out.println("finished");

    }
}
