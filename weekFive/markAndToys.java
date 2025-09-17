import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class markAndToysResult {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
    // Write your code here
      Collections.sort(prices);
      int len = prices.size();
        int sum = 0, count=0;
       for(int i=0; i<len; i++){
           sum += prices.get(i);
           count++;
           if((sum + i+1) == k){
               return count + 1;
           }
           else if(sum > k)
           {
               return count-1;
           }
       }
        
        return count;
    }

}

public class markAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = markAndToysResult.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
