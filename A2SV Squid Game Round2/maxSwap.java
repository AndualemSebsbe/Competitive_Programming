import java.util.ArrayList;
import java.util.List;

class maxSwap {
    public int maximumSwap(int num) {

        List<Integer> nums = new ArrayList<>();
        int max = num;
        if(num <= 10)
            return num;
        while(num > 0){
            nums.add(num%10);
            num /= 10;
        }

        reverse(nums);
        int n = nums.size();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                swap(nums, i, j);
                int sum = 0;
                for(int val : nums)
                    sum = sum*10 + val;
                max = Math.max(max, sum);
                swap(nums, i, j);
            }
        }

        return max;
    }

    void swap(List<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp); 
    }

    void reverse(List<Integer> nums){
        int l = 0, r = nums.size()-1;
        while(l < r){
            swap(nums, l, r);
            l += 1; r -= 1;
        }
    }
}