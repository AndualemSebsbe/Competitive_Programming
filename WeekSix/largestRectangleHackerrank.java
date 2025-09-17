import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class largestRectangleResult {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    // Write your code here
      int len = h.size();
        int maxValue = 0;
        
        if(len==1) return h.get(0);
        Stack<Integer> st = new Stack<>();
           st.add(0);
        for(int i=1; i<len ; i++){
            int curr = h.get(i);
            if(curr >= h.get(st.peek())){
                st.add(i);
            }
            else {
          while(!st.empty() && curr < h.get(st.peek())){
               int temp = h.get(st.pop());
                if(st.empty()){
                    maxValue = Math.max(maxValue, temp*i);
                }
            else {
                maxValue = Math.max(maxValue, temp*(i-st.peek()-1));
            }
            
            }  
                st.add(i);
            }
        }
     if(!st.empty()){
         int i = h.size();
         while(!st.empty()){
               int temp = h.get(st.pop());
                if(st.empty()){
                    maxValue = Math.max(maxValue, temp*i);
                }
           else {
                maxValue = Math.max(maxValue, temp*(i-st.peek()-1));
            }
            
            }  
            }
            
        
      return maxValue;  
    }

}

public class largestRectangleHackerrank {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = largestRectangleResult.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
