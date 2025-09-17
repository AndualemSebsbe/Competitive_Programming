import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class countingSortResult {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
       long num=arr.size();
        ArrayList<Integer> arr1= new ArrayList<Integer>();
       if((num>=100) && (num<=1000000)){
      
       for(int i=0; i<100; i++){
           arr1.add(0);
       }
       int j;
           for(int i=0; i<num; i++){              
               if((arr.get(i)>=0) && (arr.get(i)<100)){
               j=arr.get(i);
               arr1.set(j,(arr1.get(arr.get(i))+1));
           
           }
           }
       }   
     return arr1;
}
}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = countingSortResult.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
