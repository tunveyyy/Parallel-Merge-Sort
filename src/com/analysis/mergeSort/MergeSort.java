package com.analysis.mergeSort;

import java.util.*;

public class MergeSort {

    public static void parallelMergeSort(int[] a, int maxThreadCount, int minSize) {
        if (maxThreadCount <= 1) {
            mergeSort(a);
        }
        else if (a.length >= minSize) {
            // split array in half
            int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            // sort the halves

            Thread lThread = new Thread(new Multithreading(left,  maxThreadCount / 2, minSize));
            Thread rThread = new Thread(new Multithreading(right, maxThreadCount / 2, minSize));
            lThread.start();
            rThread.start();

            try {
                lThread.join();
                rThread.join();
            } catch (InterruptedException ie) {}

            // merge them back together
            merge(left, right, a);
        }
    }

    // Arranges the elements of the given array into sorted order
    // using the "merge sort" algorithm, which splits the array in half,
    // recursively sorts the halves, then merges the sorted halves.
    // It is O(N log N) for all inputs.
    public static void mergeSort(int[] a) {

        if (a.length >= 2) {
            // split array in half
            int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            // sort the halves
            mergeSort(left);
            mergeSort(right);

            // merge them back together
            merge(left, right, a);
        }
    }

    // Combines the contents of sorted left/right arrays into output array a.
    // Assumes that left.length + right.length == a.length.
    public static void merge(int[] left, int[] right, int[] a) {

        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
                a[i] = left[i1];
                i1++;
            }
            else {
                a[i] = right[i2];
                i2++;
            }
        }
    }

    // Swaps the values at the two given indexes in the given array.
    public static final void swap(int[] a, int i, int j) {

        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

}
/*
References: https://courses.cs.washington.edu/courses/cse373/13wi/lectures/03-13/26-parallel-algorithms.pdf
TODO:
2. Student supplied tests are present
3. Student supplied test include answers in unit tests or comments
4. Includes timing with different configuration settings
 */

