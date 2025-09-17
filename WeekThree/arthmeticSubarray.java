import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class arthmeticSubarray {
    
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int m=l.length;
            int n=nums.length;
            // fill all list of boolean to true on instantiation
            List<Boolean> list = new ArrayList<Boolean>(Arrays.asList(new Boolean[l.length]));        
           // Collections.fill(list,true);
    
            for(int j=0; j<m; j++){
               // create new arraylist of Integer and set the values of nums to it
               List<Integer> numsList = new ArrayList<Integer>();
                for(int i=l[j]; i<=r[j]; i++)
               numsList.add(nums[i]);
                 //sort the array
               Collections.sort(numsList);
               // the diffrence between two consecutive numbers 
                // starts from the index of l[j] to r[j]
                int diff = (numsList.get(1) - numsList.get(0));
                for(int i=1; i<numsList.size(); i++){
                    if(diff != (numsList.get(i)-numsList.get(i-1))){
                        list.set(j, false);
                        break;
                    }
                  if(i+1==numsList.size()) 
                    list.set(j, true);
                    
                }                      
            }
            return list;
        }
}
