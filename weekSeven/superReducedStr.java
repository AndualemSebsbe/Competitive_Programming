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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
    
        StringBuilder str = new StringBuilder(s);
        boolean flag = true;
        while(flag){
            flag = false;
        for(int i = 0; i < str.length()-1; i++){
        if(str.charAt(i) == str.charAt(i+1)){
            str.delete(i, i+2);
            flag = true;
        }
        }
        }
         if(str.length() == 0){
             return "Empty String";
         }
        else{
            return str.toString();
        }   
    }
}


public class superReducedStr {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
