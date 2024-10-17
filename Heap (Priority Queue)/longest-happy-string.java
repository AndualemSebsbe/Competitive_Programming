class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a > 0) 
            pq.offer(new int[]{a, 'a'});
        if (b > 0) 
            pq.offer(new int[]{b, 'b'});
        if (c > 0) 
            pq.offer(new int[]{c, 'c'});

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            // Check if last two characters are the same.
            int len = res.length();
            if (len >= 2 && res.charAt(len - 1) == first[1] &&
                res.charAt(len - 2) == first[1]) {

                if (pq.isEmpty()) 
                    break;  // No more valid characters.

                // Pick the second character.
                int[] second = pq.poll();
                res.append((char) second[1]);
                second[0] -= 1;

                if (second[0] > 0) 
                    pq.offer(second);
            } else {
                res.append((char) first[1]);
                first[0] -= 1;
            }
            
            if (first[0] > 0) 
                pq.offer(first);
        }

        return res.toString();
    }
}