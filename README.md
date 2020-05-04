This program implements parallel sorting program using merge sort. Parallelism is achieved via multi-threading in java

Main function - Application.java
Input parameters are taken via command line arg: 
- Array of numbers to be sorted which are present in a file. The file has to be in the same directory as Application.java
- Minimum size of the array which to use multithreading.
- Maximum number of threads to be created.
    
Output:
- Output will be displayed in a tabular form 

| No of Elements| Parallel execution time| General execution time  |
| ------------- |:-------------:| ------------:|
| 16384000 	    |  892 ms 	    |       1288 ms|
|  32768000 	|   1801 ms     |       2574 ms|
|  65536000     |   3670 ms     |       5380 ms|

Unit testing:
    Code SNIPPET for unit testing is commented in Application.java where a set of random arrays were generated for testing.
    Uncomment the file to generate data.
