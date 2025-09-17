class Solution {
    public String strWithout3a3b(int a, int b) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a != 0)
            maxHeap.add(new int[] {a, 'a'});
        if (b != 0)
            maxHeap.add(new int[] {b, 'b'});
        
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            int len = res.length();
            if (len >= 2 && res.charAt(len - 1) == first[1] && res.charAt(len - 2) == first[1]) {
                int[] second = maxHeap.poll();
                res.append((char) (second[1]));
                second[0] -= 1;

                if (second[0] != 0)
                    maxHeap.add(second);
            }
            else {
                res.append((char) (first[1]));
                first[0] -= 1;
            }

            if (first[0] != 0)
                maxHeap.add(first);
        }

        return res.toString();
    }
}