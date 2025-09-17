class hIndex_II {
    public int hIndex(int[] citations) {
        int n = citations.length, r = 1, l = n;
        if(citations[n-1] < 1)
            return 0;
        if(n == 1) return 1;
        while(r <= l){
            int mid = r + (l - r)/2;
            int i = n - mid;
            if(citations[i] > mid)
                r = mid + 1;
            else if(citations[i] < mid)
                l = mid - 1;
            else
                return mid;
        }
        return l;
    }
}