package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!!!! Welcome to JAVA World!");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

