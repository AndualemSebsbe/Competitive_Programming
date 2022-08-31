import java.util.Scanner;
import java.util.*;
class twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < n; i++)
           nums[i] = sc.nextInt();
        System.out.println("Enter the target");
        int target = sc.nextInt();
        int[] arr = twoSum(nums, target);
       System.out.println(Arrays.toString(arr));
    
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        
        int[] arr = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
                break;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return arr;
    }
}