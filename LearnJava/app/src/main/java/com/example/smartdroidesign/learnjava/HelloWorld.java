package com.example.smartdroidesign.learnjava;

public class HelloWorld {
    public static void main(String[] args) {
        int lives = 0;
        boolean isGameOver = (lives > 1);
        if (isGameOver) {
            System.out.println("Game over");
        } else {
            System.out.println("Look alive");
        }
    }
}
