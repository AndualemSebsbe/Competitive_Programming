import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class NumOfCarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
       
        double time[] = new double[len];
        // store the position element as a key and speed of element as a value
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<len; i++)
            map.put(position[i], map.getOrDefault(position[i], 0) + speed[i]);
        // Sort the array
        Arrays.sort(position);
        Stack<Double> st = new Stack<>();
        for(int i=0; i< len; i++){
            time[i] = (double)(target - position[i])/(double)map.getOrDefault(position[i], 0);
        }
       
        int count = 0;
        for(int i=0; i< len; i++){
            while(!st.empty() && st.peek() <= time[count]){
                st.pop();             
            }
            st.push(time[count]);
            count++;
        }
        int fleet = st.size();
        return fleet;
    }
}