class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap();
        for(int[] match : matches)
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        
        TreeSet<Integer> set1 = new TreeSet();
        for(int key : map.keySet())
            if(map.get(key) == 1)
                set1.add(key);
                
        TreeSet<Integer> set2 = new TreeSet();
        for(int[] match : matches)
            if(!map.containsKey(match[0]))
                set2.add(match[0]);
        
        List<Integer> loser = new ArrayList(set1);
        List<Integer> winner = new ArrayList(set2);
       
        List<List<Integer>> res = new ArrayList();
        res.add(winner);
        res.add(loser);
        
        return res;
    }
}