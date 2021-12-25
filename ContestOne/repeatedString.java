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
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
        int len=s.length();
        int count=0;
        for(int i=0; i<len; i++){
        if((s.charAt(i)) == 'a'){
            count++;
          }
         
        }
        
        // finding maximum occorence of string "a" in the (n/len)*len length of string
        long num = n/len ; // number of repeated string s 
        
        if(count==0){
          return count*num ;
        }
        //get the length of remaining
        long rem = n%len;
        int remCount = 0;
        for(int i=0; i< rem; i++){
            if((s.charAt(i)) == 'a'){
            remCount++;
          }
        }
        return count*num + remCount;
    }

}

public class repeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
