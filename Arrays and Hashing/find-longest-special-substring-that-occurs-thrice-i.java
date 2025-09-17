class Solution {

    public int maximumLength(String s) {
        Map<Pair<Character, Integer>, Integer> count = new HashMap<>();
        int substringLen = 0;

        for (int start = 0; start < s.length(); start++) {
            char c = s.charAt(start);
            substringLen = 0;

            for (int end = start; end < s.length(); end++) {
                if (c == s.charAt(end)) {
                    substringLen++;
                    Pair<Character, Integer> key = 
                        new Pair<>(c, substringLen);
                    count.put(key, count.getOrDefault(key, 0) + 1);
                } else
                    break;
            }
        }

        int ans = 0;
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : 
            count.entrySet()) {
            int len = entry.getKey().getValue();
            if (entry.getValue() >= 3 && len > ans)
                ans = len;
        }

        return ans == 0 ? -1 : ans;
    }
}