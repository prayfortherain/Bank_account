import java.util.concurrent.Semaphore;

public class GoodGuy extends Thread implements Runnable {
    Account lovely;
    Semaphore m;

    public GoodGuy(Account lovely, Semaphore m) {
        this.lovely = lovely;
        this.m = m;
    }

    @Override
    public void run() {
        while (true){
            try {
                m.acquire();
                lovely.replenish(1000);
                System.out.println(lovely.balance);
                m.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
