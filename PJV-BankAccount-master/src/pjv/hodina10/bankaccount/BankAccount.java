
package pjv.hodina10.bankaccount;

public class BankAccount {   
    
   private double balance;
   
   public BankAccount(double balance){
       this.balance = balance;
   }
/**
 * 
 * @param amount Amount of money which will be added to the balance.
 * @throws InterruptedException 
 */
   synchronized public void addAmount(double amount) throws InterruptedException{
       double balance = getBalance();       
       balance += amount;
       Thread.sleep(40);
       setBalance(balance);
   }
   
   synchronized public double getBalance() throws InterruptedException{
       Thread.sleep(40);
       return balance;
   }
   
   synchronized public void setBalance(double balance){
       this.balance = balance;
   }
   
}
