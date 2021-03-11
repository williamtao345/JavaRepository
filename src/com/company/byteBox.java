package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class byteBox {

    public static void main(String[] args) {
        int[] minOperations = getMinOperations("001011");
        System.out.println(Arrays.toString(minOperations));
    }

    public static int[] getMinOperations(String sBoxes) {
        int[] minOperations = new int[sBoxes.length()];
        ArrayList<Boolean> iBoxes = new ArrayList<>();

        toArray(sBoxes, iBoxes);

        for (int i = 0; i < sBoxes.length(); i++) {
            minOperations[i] = getTargetBoxSteps(iBoxes, i);
        }

//        viewOperations(minOperations, iBoxes);

        return minOperations;
    }

    private static void toArray(String sBoxes, ArrayList<Boolean> iBoxes) {
        for (int i = 0; i < sBoxes.length(); i++) {
            if (sBoxes.charAt(i) == '1')
                iBoxes.add(true);
            else
                iBoxes.add(false);

        }
    }

    private static int getTargetBoxSteps(ArrayList<Boolean> iBoxes, int targetPlace) {
        int steps = 0;
        for (int i = 0; i <= iBoxes.lastIndexOf(true); i++) {
            if (iBoxes.get(i).equals(true)) {
                steps += Math.abs(i - targetPlace);
            }
        }
        return steps;
    }

    private static void viewOperations(int[] minOperations, ArrayList<Boolean> iBoxes) {
        for (int i = 0; i < minOperations.length; i++) {
            for (int j = 0; j < minOperations.length; j++) {
                if (j == i)
                    System.out.print(">");
                else
                    System.out.print(" ");

                if (iBoxes.get(j).equals(true))
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            System.out.print("  " + minOperations[i]);
            System.out.println();
        }
    }

}
