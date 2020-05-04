package com.analysis.mergeSort;
public class Multithreading implements Runnable {
    private int[] a;
    private int maxThreadCount;
    private int minSize;

    public Multithreading(int[] a,  int maxThreadCount) {
        this.a = a;
        this.maxThreadCount = maxThreadCount;
    }

    public void run() {
        MergeSort.parallelMergeSort(a, maxThreadCount);
    }
}

