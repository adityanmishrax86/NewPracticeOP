package org.example.selu.ThreadOp;

import java.util.concurrent.atomic.AtomicBoolean;

public class Basics2 extends Thread {

    public Basics2(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i =1; i < 10; i ++) {
                Thread.sleep(100);
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void baseThreadRunner() {
        Basics2 bs = new Basics2("Hello Baby");
        System.out.println(bs.getName());
        bs.start();
        System.out.println(bs.getPriority());
        System.out.println(bs.threadId());
    }

    public static void twoThreads() {
        final int MAX_VALUE = 20;
        Object lock = new Object();
//        final boolean[] isEvenTurn = {true};
        AtomicBoolean isEvenTurn = new AtomicBoolean(true);

        Thread evenThread = new Thread(() -> {
            for(int i = 2; i <= MAX_VALUE; i += 2) {
                synchronized (lock) {
                    while (!isEvenTurn.get()) {
                        try {
                            System.out.println("Entering Even Lock State");
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Even Number is: " + i);
                    isEvenTurn.set(false);
                    lock.notify();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for(int i = 1; i <= MAX_VALUE; i += 2) {
                synchronized (lock) {
                    while (isEvenTurn.get()) {
                        try {
                            System.out.println("Entering Odd Lock State");
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Odd Number is: " + i);
                    isEvenTurn.set(true);
                    lock.notify();
                }
            }
        });

        evenThread.start();
        System.out.println(evenThread.threadId());
        oddThread.start();
        System.out.println(oddThread.threadId());


    }


    public static void main(String[] args) {

        twoThreads();


    }
}
