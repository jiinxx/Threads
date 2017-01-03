package demo3;

class Worker extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
        }
    }
}

public class App {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
    }
}
