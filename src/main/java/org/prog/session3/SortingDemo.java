package org.prog.session3;

import java.util.Random;

public class SortingDemo {

    public static void main(String[] args) {
        //TODO: If gnome is in 1st element -> go to next (if i == 0 -> i++)
        //TODO: If pots[i] < pots[i-1] -> swap and step back
        //TODO: if i == pots.length - 1 && no swap -> END

        int index = 0;
        boolean swapped = false;

//        int[] pots = {0, 2, 1, 5, 8, 4, 10, 3, 6, 7};

        Random rand = new Random();

        int[] pots = new int[500];
        for (int i = 0; i < pots.length; i++) {
            pots[i] = rand.nextInt(2500);
        }

        int gnomeRuns = 0;

        while (true) {
            gnomeRuns++;
            if (!swapped || index == 0) {
                index++;
            }
            if (pots[index] < pots[index - 1]) {
                swapped = true;
                int temp = pots[index];
                pots[index] = pots[index - 1];
                pots[index - 1] = temp;
                index--;
            } else {
                swapped = false;
            }
            if (!swapped && index == pots.length - 1) {
                break;
            }
        }

        System.out.println("Gnome ran : " + gnomeRuns);

        for (int i = 0; i < pots.length; i++) {
            System.out.println(pots[i]);
        }
    }
}
