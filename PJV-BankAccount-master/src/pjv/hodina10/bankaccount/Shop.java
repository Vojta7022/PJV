
package pjv.hodina10.bankaccount;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Shop {
    
    List<Person> customers;
    double [] bills;
    
    
    public Shop(List<Person> customers, double [] bills){
        this.customers = customers;
        this.bills = bills;
    }

    public void makeCustomersPayBills() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Person customer : customers) {
            executor.submit(() -> {
                try {
                    for (double payment : bills) {
                        customer.removeAmountFromBankAccount(payment);
                        System.out.println("Shop start");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Shop end");
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(10); // Wait for all tasks to finish
        }
    }
    
}
