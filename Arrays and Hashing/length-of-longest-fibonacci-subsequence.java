class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) 
            set.add(arr[i]);
        
        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int fib1 = arr[i];
                int fib2 = arr[j];

                int res = fib1 + fib2, count = 0;
                if (set.contains(res))
                    count += 2;

                while (set.contains(res)) {
                    count += 1;
                    fib1 = fib2;
                    fib2 = res;
                    res = fib1 + fib2;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}