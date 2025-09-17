import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class topKFrequentElements {
    
    
        public int[] topKFrequent(int[] nums, int k) {
            int len = nums.length;
            
             Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int maxOcc = 0;
            //Initialize and count value of each key(element)
            for(int i=0; i<len; i++){
                int occ = map.getOrDefault(nums[i], 0) + 1;
                map.put(nums[i], occ);
                maxOcc = Math.max(maxOcc, occ);
            }
            // Initialize arraylist of an array list
            ArrayList<ArrayList<Integer>> freq = new ArrayList<ArrayList<Integer>>();
            int mplen = map.size();
            System.out.println(mplen);
            for(int i=0; i<= maxOcc; i++){
                freq.add(new ArrayList<Integer>());
            }
            
             // Use frequencies as indexes and add corresponding
            // values to the list
            for(Map.Entry<Integer, Integer> x: map.entrySet()){
               freq.get(x.getValue()).add(x.getKey());
               // System.out.print(freq.get(x.getValue()).add(x.getKey())+" ");
               
            }
             // Traverse freq[] from right side.
            int count = 0;
            int res[] = new int[k]; 
            for(int i=maxOcc, j=0; i>=0;  i--){
                for(int val: freq.get(i)){
                    count++;
                    res[j] = val;
                    j++;
                     if(count==k){
                        return res;
                        
                     }
                }
            }
            return res;
        }
    }
