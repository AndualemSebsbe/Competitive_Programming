class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            freq[c - 'a'] += 1;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);
        for (int i = 0; i < 26; i++){
            if (freq[i] > 0){
                char c = (char) ('a' + i);
                maxHeap.add(c);
            }
        }

        int push = 0, i = 0;
        int res = 0;
        while (!maxHeap.isEmpty()) {
            if (i % 8 == 0)
                push += 1;
            char c = maxHeap.poll();
            res += (freq[c - 'a'] * push);
            i += 1;
        }

        return res;
    }
}