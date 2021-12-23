import java.util.ArrayList;
import java.util.Arrays;

public class notAvaNeighbour {
    
        public int[] rearrangeArray(int[] nums) {
            int n = nums.length;
           
            Arrays.sort(nums);
            
           int mid = n/2;
           
            int i=0;       
            int j = mid + 1;
             ArrayList<Integer> res = new ArrayList<>();
            while(i<=mid && j<n){
                
                 res.add(nums[i++]);
                  res.add(nums[j++]);
            }
            while(i<=mid){
                res.add(nums[i++]);
            }
            while(j < n){
                res.add(nums[j++]);
            }
            nums = res.stream().mapToInt(num->num).toArray();
           
             return nums;
        }
    }

