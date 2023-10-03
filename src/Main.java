import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore mojno = new Semaphore(1);
        Account artutula = new Account(250);
        GoodGuy Lunin = new GoodGuy(artutula, mojno);
        BadGirl Verendyakina = new BadGirl(artutula, mojno, "Я оплатила ЖКХ");
        Lunin.start();
        Verendyakina.start();
    }
}


