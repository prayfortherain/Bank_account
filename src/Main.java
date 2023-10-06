import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Account balance = new Account(250);
        Add add = new Add(balance, semaphore);
        Limit limit = new Limit(balance, semaphore);
        add.start();
        limit.start();
    }
}


