class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0)
            return true;

        Set<Long> set = new HashSet();
        for(long i = 0; (i * i) <= c; i++){
            if(set.contains(c - (i * i)) || ((c - (i * i)) == i * i))
                return true;

            set.add(i * i);
        }

        return false;
    }
}