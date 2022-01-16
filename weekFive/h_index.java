class h_index {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[1001];
        // Fill buckets
        for(int i: citations){
            count[i]++;
        }
        // Sort array
        int indx = 0;
        
        for(int i=0; i< count.length; i++){
            while(count[i] > 0){
             citations[indx++] = i;
             count[i]--;
            }
        }
       int indx1=1;
       for(int i=n-1; indx1<= n && i>=0; i--, indx1++)
           if(citations[i] < indx1) break;
               return indx1-1;
      
    }
}