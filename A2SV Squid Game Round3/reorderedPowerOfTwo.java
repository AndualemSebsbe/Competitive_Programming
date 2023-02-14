import java.util.Arrays;

class reorderedPowerOfTwo {
    public boolean reorderedPowerOf2(int n) {
        int[] nums = count(n);

        int num = 1;
        for(int i = 0; i < 31; i++){
            if(Arrays.equals(nums, count(num)))
                return true;
           
            num *= 2;
        }

        return false;
    }

    int[] count(int num){
        int[] arr = new int[10];
        while(num > 0){
            arr[num%10] += 1;
            num /= 10;
        }

        return arr;
    }
}