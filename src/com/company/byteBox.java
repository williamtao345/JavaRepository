package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class byteBox {
    private static int getNexBallSteps(ArrayList<Boolean> iBoxes, int targetPlace) {
        for (int i = 0; i <= iBoxes.lastIndexOf(true); i++) {
            if (iBoxes.get(i).equals(true)) {
                iBoxes.set(i, false);
                return Math.abs(i - targetPlace);
            }
        }
        return -1;
    }

    private static int getNexBoxSteps(ArrayList<Boolean> iBoxesOriginal, int targetPlace) {
        ArrayList<Boolean> iBoxes = new ArrayList<>(iBoxesOriginal);
        int steps = 0;
        int flag;
        for (int i = 0; i < iBoxes.lastIndexOf(true); i++) {
            flag = getNexBallSteps(iBoxes, targetPlace);
            if (flag == -1) {
                break;
            } else {
                steps += flag;
            }
        }
        return steps;
    }

    private static void toArray(String sBoxes, ArrayList<Boolean> iBoxes) {
        for (int i = 0; i < sBoxes.length(); i++) {
            if (sBoxes.charAt(i) == '1') {
                iBoxes.add(true);
            } else {
                iBoxes.add(false);
            }
        }
    }

    private static void viewOperations(int[] minOperations, ArrayList<Boolean> iBoxes) {
        int length = Math.max(iBoxes.lastIndexOf(true), iBoxes.lastIndexOf(false)) + 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == i) {
                    if (iBoxes.get(j).equals(true))
                        System.out.print(">1");
                    else
                        System.out.print(">0");
                } else if (iBoxes.get(j).equals(true))
                    System.out.print(" 1");
                else
                    System.out.print(" 0");
            }
            System.out.print("  " + minOperations[i]);
            System.out.println();
        }
    }

    public static int[] getMinOperations(String sBoxes) {
        int[] minOperations = new int[sBoxes.length()];
        ArrayList<Boolean> iBoxes = new ArrayList<>();

        toArray(sBoxes, iBoxes);

        for (int i = 0; i < sBoxes.length(); i++) {
            minOperations[i] = getNexBoxSteps(iBoxes, i);
        }

        boolean allowViewOperations = true;
        if (allowViewOperations)
            viewOperations(minOperations, iBoxes);

        return minOperations;
    }

    public static void main(String[] args) {
        int[] minOperations = getMinOperations("001011");
        System.out.println(Arrays.toString(minOperations));
    }
}
