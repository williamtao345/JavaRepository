package com.company;

import java.util.concurrent.TimeUnit;

public class Tetris {
    private void visualizer() {

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            System.out.println(i+1);
            System.out.println(i+2);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\033[H\033[2J");
        }
    }
}
