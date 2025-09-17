import java.io.*;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class billDivisionResult {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */

    public static void bonAppetit(List<Integer> bill, int k, int b) {
    // Write your code here
      int len = bill.size();
        int sum =0;
        for(int i=0; i<len; i++){
            if(i != k){
            sum+=bill.get(i);
            }
        }
        int bactual = sum/2;
        if((b-bactual)>0){
            System.out.println(b-bactual);
        }
        else{
             System.out.println("Bon Appetit");
        }
        
    }

}

public class billDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        billDivisionResult.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
