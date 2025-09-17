class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n)
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < m; i++) {
            count1[s1.charAt(i) - 'a'] += 1;
            count2[s2.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(count1, count2))
            return true;

        int l = 0;
        for (int r = m; r < n; r++) {
            count2[s2.charAt(l++) - 'a'] -= 1;
            count2[s2.charAt(r) - 'a'] += 1;

            if (Arrays.equals(count1, count2))
                return true;
        }

        return false;
    }
}