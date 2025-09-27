package org.example.selu.ThreadOp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double bankBalance;
    private Lock lock;

    public BankAccount() {
        this.bankBalance = 0.0;
        lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            bankBalance += amount;
            System.out.println(Thread.currentThread().getName() +" Deposit Amount : $" + amount);
            System.out.println("Total Bank Balance after deposit: $"+ bankBalance);
        } finally {
            lock.unlock();
        }
    }


    public void withdraw(double amount) {
        lock.lock();
        try {
            if(amount > bankBalance) {
                System.out.println("Insufficient Amount present to withdraw");
                return;
            }
            bankBalance -= amount;
            System.out.println(Thread.currentThread().getName() + " Withdraw Amount : $" + amount);
            System.out.println("Total Bank Balance after withdraw: $"+ bankBalance);
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread deposit1 = new Thread(() -> account.deposit(10), "Deposit-1");
        Thread withdraw1 = new Thread(() -> account.withdraw(5), "Deposit-2");
        Thread deposit2 = new Thread(() -> account.deposit(20), "Withdraw-1");
        Thread withdraw2 = new Thread(() -> account.withdraw(50),"Withdraw-2");

        deposit1.start();
        deposit2.start();
        deposit1.start();
        withdraw1.start();
        withdraw2.start();


//        try {
//            deposit1.join();
//            deposit2.join();
//            withdraw1.join();
//            withdraw2.join();
//        } catch (InterruptedException e) {
//            System.out.println();
//        }
    }
}
