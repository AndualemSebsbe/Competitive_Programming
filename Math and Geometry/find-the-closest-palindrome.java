class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean isEven = len % 2 == 0;

        int mid = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long firstHalf = Long.parseLong(n.substring(0, mid + 1));
        
        List<Long> candidates = new ArrayList();
        candidates.add(buildPalindrome(firstHalf, isEven));
        candidates.add(buildPalindrome(firstHalf + 1, isEven));
        candidates.add(buildPalindrome(firstHalf - 1, isEven));
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);

        long res = 0, diff = Long.MAX_VALUE;
        long num = Long.parseLong(n);
        for (long candidate : candidates) {
            if (candidate == num)
                continue;
                
            if (Math.abs(candidate - num) < diff) {
                diff = Math.abs(candidate - num);
                res = candidate;
            }
            else if (Math.abs(candidate - num) == diff) 
                res = Math.min(res, candidate);
        }

        return String.valueOf(res);
    }

    long buildPalindrome(long left, boolean isEven) {
        long res = left;
        if (!isEven)
            left /= 10;
        
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }

        return res;
    }
}