class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx] += 1;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int idx = 0; idx < 26; idx++) {
            int c = 'a' + idx;
            if (count[idx] != 0)
                maxHeap.add(new int[] {count[idx], c});
        }

        String res = "";
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            int len = res.length();
            if (len > 0 && res.charAt(len - 1) == first[1]) {
                if (maxHeap.isEmpty())
                    return "";
                
                int[] second = maxHeap.poll();
                res += (char) (second[1]);
                second[0] -= 1;

                if (second[0] != 0)
                    maxHeap.add(second);
            }
            else {
                res += (char) (first[1]);
                first[0] -= 1;
            }

            if (first[0] != 0)
                maxHeap.add(first);
        }

        return res;
    }
}