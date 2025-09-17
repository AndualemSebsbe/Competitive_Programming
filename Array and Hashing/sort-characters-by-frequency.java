class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        PriorityQueue<Character> maxHeap = 
            new PriorityQueue((a,b) -> map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char curr = maxHeap.poll();
            
            for(int i = 0; i < map.get(curr); i++)
                sb.append(curr);
        }
        
        return sb.toString();
    }
}