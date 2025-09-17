class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long n = beans.length;
        long min = Long.MAX_VALUE, total = 0;

        for(int bean : beans)
            total += bean;

        for(int i = 0; i < n; i++){
            min = Math.min(min, total - (n - i) * beans[i]);
        }

        return min;
    }
}