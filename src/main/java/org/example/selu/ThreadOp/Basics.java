package org.example.selu.ThreadOp;

public class Basics {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Current: " +thread.getName());
        thread.setName("AC2");
        System.out.println("After: " +thread.getName());

        try {
            for (int i =0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
