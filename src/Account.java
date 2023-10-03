public class Account {
    int balance;

    Account(int balance){
        this.balance = balance;
    }
    Account(){
        this.balance = 0;
    }

   public void replenish(int money){
        this.balance += money;
    }

    public void withdraw(int money){
        this.balance -= money;
    }
}
