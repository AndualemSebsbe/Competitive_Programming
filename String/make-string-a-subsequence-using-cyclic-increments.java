class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len2 > len1)
            return false;

        int j = 0, i = 0;
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j))
                j += 1;
            else {
                char c = (char) (str1.charAt(i) + 1);
                if (c == '{')
                    c = 'a';
                if (c == str2.charAt(j))
                    j += 1;
            }
            
            i += 1;
        }
            
        return j == len2;
    }
}