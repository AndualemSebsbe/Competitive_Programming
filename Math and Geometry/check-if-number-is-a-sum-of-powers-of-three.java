class Solution {
    public boolean checkPowersOfThree(int n) {
        Set<Integer> visited = new HashSet();
        while (n > 0) {
            int val = findPowerOfThree(n);
            if (visited.contains(val))
                return false;
            
            n -= val;
            visited.add(val);
        }

        return true;
    }

    int findPowerOfThree(int n) {
        int val = 1;
        while (val * 3 <= n)
            val *= 3;
        
        return val;
    }
}