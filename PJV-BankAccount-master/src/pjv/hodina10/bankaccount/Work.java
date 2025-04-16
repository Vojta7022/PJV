
package pjv.hodina10.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Work {
    private final List<Person> employees;
    private final double [] payments;
    
    public Work(List<Person> employees, double [] payments){
        this.employees = employees;
        this.payments = payments;
    }

    public void payPayments() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Person employee : employees) {
            executor.submit(() -> {
                try {
                    for (double payment : payments) {
                        System.out.println("Work start");
                        employee.addAmountToBankAccount(payment);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Work end");
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(10); // Wait for all tasks to finish
        }
    }

//    public void payPayments() throws InterruptedException {
//        for (Person employee : employees) {
//            for (double payment : payments) {
//                Thread t = new Thread(() -> {
//                    try {
//                        employee.addAmountToBankAccount(payment);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//
//                employee.addAmountToBankAccount(payment);
//            }
//        }
//    }
    
}
