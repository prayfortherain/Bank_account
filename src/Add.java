import java.util.concurrent.Semaphore;

public class Add extends Thread implements Runnable {
    Account account;
    Semaphore m;

    public Add(Account account, Semaphore m) {
        this.account = account;
        this.m = m;
    }

    @Override
    public void run() {
        while (true){
            try {
                m.acquire();
                account.replenish(1000);
                System.out.println(account.balance);
                m.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
