class findOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if(len % 2 != 0)
            return new int[0];
        int max = 0;
        int[] cnt = new int[100001];
        for(int num: changed){
            cnt[num]++;
            max = Math.max(max, num);
        }
        
        int[] original = new int[len/2];
        int j = 0;
        for(int i = 0; i <= max; i++){
           while(cnt[i] > 0){
               cnt[i]--;
               if(i*2 <= 100000 && cnt[i*2] > 0){
                   original[j++] = i;
                   cnt[i*2]--;
               }
               else
                   return new int[0];
           }
        }
        
        return original;
    }
}