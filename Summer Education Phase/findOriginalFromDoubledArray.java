class finOriginalFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if(len % 2 != 0) return new int[0];
        
        Arrays.sort(changed);
        int[] cnt = new int[100001];
        for(int num : changed){
           cnt[num]++;
        }
        
        int[] ans = new int[len/2];
        int i = 0;
        for(int num : changed){
            while(cnt[num]-- > 0){
                ans[i++] = num;
                if(2*num > 100000) return new int[0];
                cnt[2*num]--;
                if(cnt[2*num] < 0) return new int[0];
            }
        }
        
        return ans;
    }
}