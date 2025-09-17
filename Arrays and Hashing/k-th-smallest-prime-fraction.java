class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, int[]> map = new TreeMap();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                double key = arr[i] / (double)arr[j];
                map.put(key, new int[]{arr[i], arr[j]});
            }
        }
        
        for(double key : map.keySet()){
            k -= 1;
            if(k == 0)
                return map.get(key);
        }

        return new int[0];
    }
}