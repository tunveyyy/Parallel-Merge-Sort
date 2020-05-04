package com.analysis.mergeSort;
public class Multithreading implements Runnable {
    private int[] a;
    private int maxThreadCount;
    private int minSize;

    public Multithreading(int[] a,  int maxThreadCount, int minSize) {
        this.a = a;
        this.maxThreadCount = maxThreadCount;
        this.minSize = minSize;
    }

    public void run() {
        MergeSort.parallelMergeSort(a, maxThreadCount, minSize );
    }
}

