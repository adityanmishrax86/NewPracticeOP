package org.example.selu.ThreadOp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenThreadRipper {

    public static void threadRipperOne() {

        Thread oddThread = new Thread(() -> {
            for(int i = 1; i <= 100; i+=2) {
                System.out.println("Odd : " + i);
                try {
                    Thread.sleep(10); // Added for better interleaving
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted : " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for(int i = 2; i <= 100; i+=2) {
                System.out.println("Even : " + i);
                try {
                    Thread.sleep(10); // Added for better interleaving
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted : " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
        });


        oddThread.setName("Odd Thread " + oddThread.threadId());
        evenThread.setName("Even Thread " + evenThread.threadId());

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("I should be at last");
    }

    public static void threadRipperTwo() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable oddThread = () -> {
            for(int i = 1; i <= 100; i+=2) {
                System.out.println("Odd : " + i);
                try {
                    Thread.sleep(10); // Added for better interleaving
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted : " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable evenThread = () -> {
            for(int i = 2; i <= 100; i+=2) {
                System.out.println("Even : " + i);
                try {
                    Thread.sleep(10); // Added for better interleaving
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted : " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
        };

        executorService.submit(oddThread);
        executorService.submit(evenThread);

        executorService.shutdown();
        while(!executorService.isTerminated()) {

        }
        System.out.println("I am at last");
    }

    public static void main(String[] args) {
        threadRipperTwo();
    }
}
