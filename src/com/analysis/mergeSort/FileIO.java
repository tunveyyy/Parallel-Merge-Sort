package com.analysis.mergeSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class FileIO {

    private static final Random RAND = new Random(50);   // random number generator
    public static int[] readFile(File filename){

        List<String> logs = new ArrayList<>();
        try{
            Scanner scanFile =  new Scanner(filename);
            while(scanFile.hasNext()) {
                logs.add(scanFile.nextLine());
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        int[] input = new int[logs.size()];
        for(int i = 0; i < logs.size(); i++) {
            input[i] = Integer.parseInt(logs.get(i));
        }
        return input;
    }


    // Creates an array of the given length, fills it with random
    // non-negative integers, and returns it.
    // This array was used for unit testing

    public int[] createRandomArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RAND.nextInt(1000000);

            length *= 2;
        }
        return a;
    }

    // Returns true if the given array is in sorted ascending order.
    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
    // Randomly rearranges the elements of the given array.
    public static void shuffle(int[] a) {

        for (int i = 0; i < a.length; i++) {
            // move element i to a random index in [i .. length-1]
            int randomIndex = (int) (Math.random() * a.length - i);
            MergeSort.swap(a, i, i + randomIndex);
        }
    }



}
