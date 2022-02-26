public class findDuplicateNum {
  
        public int findDuplicate(int[] nums) {
            int l = 1, r = nums.length;
            int repeated = 0;
            while(l <= r){
                int mid = l + (r - l)/2;
                int count = 0;
                for(int i : nums)
                    if(i <= mid) count += 1;
                if(count > mid){
                    repeated = mid;
                    r = mid - 1;
                }
                else
                    l = mid + 1;
            }
            return repeated;
        }
    }
