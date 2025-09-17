class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] count = new int[n + 1];
        for (int[] shift : shifts) {
            int l = shift[0], r = shift[1], dir = shift[2];
            int val = dir == 1 ? 1 : -1;
            count[l] += val;
            count[r + 1] -= val;
        }

        int sum = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < count.length - 1; i++) {
            sum += count[i];
            int increaseBy = ((ch[i] - 'a') + sum) % 26;
            if (increaseBy < 0)
                increaseBy += 26;

            ch[i] = (char) ('a' + increaseBy);
        }

        return String.valueOf(ch);
    }
}