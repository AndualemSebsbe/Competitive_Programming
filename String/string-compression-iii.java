class Solution {
    public String compressedString(String word) {
        int count = 1, n = word.length();
        char c = word.charAt(0);

        String res = "";

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == c) {
                count += 1;
                if (count == 9) {
                    res += (count + "" + c);
                    count = 0;

                    if (i + 1 < n)
                        c = word.charAt(i + 1);
                    else
                        c = '\0';
                }
            } else {
                res += (count + "" + c);
                count = 1;
                c = word.charAt(i);
            }
        }

        if (c != '\0' && count != 0)
            res += (count + "" + c);

        return res;
    }
}