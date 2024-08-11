class Solution {
    List<String> res = new ArrayList();
    String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return res;

        combinations(digits, "", 0);

        return res;
    }

    void combinations(String digits, String str, int i) {
        if (digits.length() == str.length()) {
            res.add(str);
            return;
        }

        int digit = digits.charAt(i) - '0';
        String letters = keys[digit];
        for (char letter : letters.toCharArray())
            combinations(digits, str + letter, i + 1);
    }
}