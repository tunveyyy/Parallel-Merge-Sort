## What is this?
This program implements parallel sorting program using merge sort. Parallelism is achieved via multi-threading.
## How to run the project
**Option 1**
- Download the jar file
- Run the jar file as `java -jar MultiThreadingMergeSort.jar <inputfile.csv> <minimumArraySize> <maxThreads>`

**Option 2**
- Open in an IDE
- In the top right corner you will see an option to run the file. Hit the button
- Go to Edit configuration and under Program arguments enter the command line arguments
- Ensure the Project compiler output points to `/Parallel-Merge-Sort/out`
- Ensure that Project SDK is set to 12 `[ File -> Project Structure -> Project SDK]`
- Run the file


## Input parameters
Accepted via command line arg: 
- Array of numbers to be sorted which are present in a file. The file has to be in the same directory as Application.java
- Minimum size of the array which to use multithreading.
- Maximum number of threads to be created.
    
## Output:

Number of threads: 4  Minimum Array Size: 2

|No of Elements    |Multi-threading Time| Normal Time 	    |
|------------------|--------------------|-------------------|
|      1000 	   |      2 ms 		    |          0 ms     |
|      2000 	   |      1 ms 		    |          0 ms 	|
|      4000 	   |      2 ms 		    |          0 ms 	|
|      8000 	   |      1 ms 		    |          1 ms 	|
|     16000 	   |      2 ms 		    |          2 ms 	|
|     32000 	   |      4 ms 		    |         10 ms 	|
|     64000 	   |      4 ms 		    |            5 ms 	|
|    128000 	   |      7 ms 		    |         12 ms 	|
|    256000 	   |     18 ms 		    |         22 ms 	|
|    512000 	   |     33 ms 		    |         33 ms 	|
|   1024000 	   |     74 ms 		    |        108 ms 	|
|   2048000 	   |     110 ms 	    |        144 ms 	|
|   4096000 	   |    237 ms 		    |        300 ms 	|
|   8192000 	   |    453 ms 		    |        612 ms 	|
|  16384000 	   |    892 ms 		    |       1288 ms 	|
|  32768000 	   |   1801 ms 		    |       2574 ms 	|
|  65536000    	   |   3670 ms 		    |       5380 ms 	|
--------------------------------------------------------------

## Unit testing:


- Code Snippet for unit testing is commented out in Application.java where a set of random arrays were generated for testing.
- Uncomment the file to generate data.

## Observations :
- We could observe that for smaller size of data, multithreading is an expensive operation as it needs more time to create threads than to  run the program on main thread.
- The real advantage of parallelism is seen when the size of input increases. With increased size, it becomes difficult to perform sorting and multithreading will help in dividing the work and solve it faster. The attached output shows the same trend.
- The number of threads should ideally be maxed out to number of cores in the system to see the effect of multithreading. If the number of threads extends beyond the cores, then multi-threading will be provided by the OS and the performance varies from machine to machine.