import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    // Write your code here
    int num=a.size();
    int count=0;
      for(int i=0; i< num; i++){
          for(int j=0; j<num-1; j++){
              if (a.get(j) > a.get(j+1)) {
            Collections.swap(a, j, j+1);
            count++;
          }
      }
    }
   System.out.println("Array is sorted in "+count+" swaps.\n"+"First Element: "+a.get(0)+"\nLast Element: "+a.get(num-1));
}

}
public class bubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}
