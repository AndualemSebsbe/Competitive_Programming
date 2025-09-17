class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        for (int i = 2; i <= right; i++) 
            isPrime[i] = true;
        
        // Use Seive of Eratosthenes to mark non-primes
        // Only need to check up to the square root of end (right)
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList();
        for (int i = left; i <= right; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        int n = primes.size();
        if (n < 2)
            return new int[] {-1, -1};

        int[] minDiff = {Integer.MAX_VALUE, -1};
        for (int i = 0; i < n - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff[0]) {
                minDiff[0] = diff;
                minDiff[1] = i;
            }
        }

        int[] res = new int[2];
        int idx = minDiff[1];
        res[0] = primes.get(idx);
        res[1] = primes.get(idx + 1);

        return res;
    }
}