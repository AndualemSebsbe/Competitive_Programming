class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if(n == 0)
            return len;
        Map<Character, Integer> map = new HashMap();
        int maxFreq = 0;
        for(char c : tasks){
            int occ = map.getOrDefault(c, 0) + 1;
            map.put(c, occ);
            maxFreq = Math.max(maxFreq, occ);
        }

        int count = 0;
        for(char c : map.keySet()){
            if(map.get(c) == maxFreq)
                count += 1;
        }

        // number of unique task and cooldown(idle)
        int numEachGp = n + 1;
        // number of group
        int numGp = maxFreq - 1;
        int res = numEachGp * numGp + count;
        
        int rem = len - res;
        if(rem > 0)
            res += rem;

        return res;
    }
}