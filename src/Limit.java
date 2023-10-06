import java.util.concurrent.Semaphore;

public class Limit extends Thread implements Runnable {
    Account owner;
    Semaphore m;

    public Limit(Account owner, Semaphore m) {
        this.owner = owner;
        this.m = m;
    }

    @Override
    public void run() {
        System.out.println("i'm started");
        while (true) {
            try {
                m.acquire();
                if(owner.balance >= 10000){
                    owner.withdraw(10000);
                }
                m.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
