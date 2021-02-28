package com.company;

public class KickCount3 {
    public static int[] run(int amount) {
        boolean[] people = new boolean[amount];

        int[] kickSequence = new int[amount - 1];
        int kickSequenceFlag = 0;

        int pointer = 0;
        int flag = 0;
        int outNumber = 0;
        while (outNumber < amount - 1) {
            if (!people[pointer]) {
                flag++;
                if (flag % 3 == 0) {
                    people[pointer] = true;
                    kickSequence[kickSequenceFlag] = pointer;
                    kickSequenceFlag++;
                    outNumber++;
                }
            }
            pointer++;
            pointer %= amount;
        }

        for (int i = 0; i < amount; i++) {
            if (!people[i]) {
                System.out.println(i + 1 + " is the last one;\n");
                break;
            }
        }

        return kickSequence;
    }

    public static int digitsOf(int x) {
        int count = 0;
        do {
            x /= 10;
            count++;
        } while (x != 0);
        return count;
    }

    public static void printArray(int length, int[] array) {
        for (int i = 0; i < length; i++) {
            if (array[i] == -1) {
                for (int j = 0; j < digitsOf(i + 1); j++)
                    System.out.print("-");
                System.out.print(" ");
            } else
                System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void kickingViewer(int n, int[] kickSequence) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        printArray(n, numbers);
        for (int i = 0; i < n - 1; i++) {
            numbers[kickSequence[i]] = -1;
            if (i == n - 2 || kickSequence[i + 1] < kickSequence[i])
                printArray(n, numbers);
        }
    }

    public static void main(String[] args) {
        int n = 0;
        int[] kickingSequence = run(n);
        kickingViewer(n, kickingSequence);
    }
}
