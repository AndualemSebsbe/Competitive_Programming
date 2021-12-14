import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    int temp=arr.get(n-1);
    
     for(int i=n-1; i>0; i--){
         if(temp < arr.get(i-1)){
             arr.set(i, arr.get(i-1));
             printArray(n, arr);
            
             }
            else
            {
                arr.set(i, temp);
               printArray(n, arr);
                break;
            } 
         }
         
     }
    
     public static void printArray(int n, List<Integer> arr){
    for(int i=0; i<n; i++){
        System.out.print(arr.get(i)+" ");      
    }
    System.out.println();
   }
    }

  

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
