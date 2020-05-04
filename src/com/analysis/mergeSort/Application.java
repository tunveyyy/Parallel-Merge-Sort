package com.analysis.mergeSort;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        File file = new File(args[0]);
        int min = Integer.parseInt(args[1]);
        int threads = Integer.parseInt(args[2]);
        int[] input = FileIO.readFile(file);

        System.out.println("File Name: "+args[0]+" Minimum array size: "+min+" Max thread Count: " +threads);
        System.out.println("_________________________________________________________");
        System.out.println("|No of Elements |Multi-threading Time| Normal Time \t \t|");
        System.out.println("|---------------|--------------------|------------------|");
        /*
        ** For testing, I have generated files via createRandomfunction
        ** To verify working of this program uncomment the following lines to generate dummy data
        */

        /*
        int LENGTH = 100;
        int RUNS = 17;
        for(int i = 0; i <= RUNS;i++) {
            input = new FileIO().createRandomArray(LENGTH);
         */

        // run the algorithm and time how long it takes
        long startTime1 = System.currentTimeMillis();
        MergeSort.parallelMergeSort(input, threads, min);
        long endTime1 = System.currentTimeMillis();

        //Extract execution time for Merge sort wihout multi-threading
        long startTime2 = System.currentTimeMillis();
        MergeSort.mergeSort(input);
        long endTime2 = System.currentTimeMillis();


        System.out.printf("|%10d \t| %6d ms \t\t | %10d ms \t| \n", input.length, endTime1 - startTime1, endTime2 - startTime2);
        /* // For unit testing uncomment this
        LENGTH *= 2;
        }
         */
        System.out.println(" --------------------------------------------------------");

    }

    }

