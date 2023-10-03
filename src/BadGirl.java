import java.util.concurrent.Semaphore;

public class BadGirl extends Thread implements Runnable {
    Account owner;
    Semaphore m;
    String oplata;

    public BadGirl(Account owner, Semaphore m, String oplata) {
        this.owner = owner;
        this.m = m;
        this.oplata = oplata;
    }

    @Override
    public void run() {
        System.out.println("i'm started");
        while (true) {
            try {
                m.acquire();
                if(owner.balance >= 10000){
                    owner.withdraw(10000);
                    System.out.println(oplata);
                }
                m.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
