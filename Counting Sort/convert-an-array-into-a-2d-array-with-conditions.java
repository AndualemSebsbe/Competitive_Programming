class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int maxOcc = 0, n = nums.length;
        int[] count = new int[n + 1];
        for(int i = 0; i < n; i++){
            count[nums[i]] += 1;
            maxOcc = Math.max(maxOcc, count[nums[i]]);
        }

        List<List<Integer>> res = new ArrayList();
        while(maxOcc-- > 0){
            List<Integer> list = new ArrayList();
            for(int i = 0; i <= n; i++){
                if(count[i] > 0){
                    list.add(i);
                    count[i] -= 1;
                }
            }

            res.add(list);
        }

        return res;   
    }
}