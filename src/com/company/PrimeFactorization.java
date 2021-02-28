package com.company;

import java.lang.Math;

//Example (In Main.java): PrimeFactorization.Factorize(90);

public class PrimeFactorization {
    private static int MinPrime(int num) {
        int x = (int) Math.sqrt(num);
        for (int i = 2; i <= x; i++) {
            if (num % i == 0)
                return i;
        }
        return num;
    }

    public static void Factorize(int number) {
        int x = MinPrime(number);
        if (x != 1) {
            System.out.print(x);
            number /= x;
            x = MinPrime(number);
        }
        while (x != 1)
        {
            System.out.print(" * " + x);
            number /= x;
            x = MinPrime(number);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrimeFactorization.Factorize(11136);
    }
}
