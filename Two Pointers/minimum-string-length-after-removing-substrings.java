class Solution {
    public int minLength(String s) {
        int l = 0;
        while (l < s.length() - 1) {
            String sub = s.charAt(l) + "" + s.charAt(l + 1);
            if (sub.equals("AB") || sub.equals("CD")) {
                if (l + 2 == s.length())
                    s = s.substring(0, l);
                else
                    s = s.substring(0, l) + s.substring(l + 2);
                l = -1;
            }

            l += 1;
        }

        return s.length();
    }
}