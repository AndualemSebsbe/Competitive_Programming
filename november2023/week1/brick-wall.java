class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countGaps = new HashMap();
        countGaps.put(0, 0);
        for(int r = 0; r < wall.size(); r++){
            int total = 0;
            for(int brick = 0; brick < wall.get(r).size() - 1; brick++){
                total += wall.get(r).get(brick);
                countGaps.put(total, countGaps.getOrDefault(total,0)+1);
            }
        }

        int maxGaps = 0;
        for(int gaps : countGaps.values())
            maxGaps = Math.max(maxGaps, gaps);
        
        return wall.size() - maxGaps;
    }
}