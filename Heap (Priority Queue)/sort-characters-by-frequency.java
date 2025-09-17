class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet())
            pq.add(c);

        String res = "";
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int occ = map.get(c);
            while (occ-- > 0)
                res += c;
        }

        return res;
    }
}