class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        while (n-- > 1) {
            StringBuilder str = new StringBuilder();
            str.append(sb);
            str.append("1");
            StringBuilder inv = invert(sb);
            String rev = reverse(inv);
            str.append(rev);
            sb = new StringBuilder(str);
        }

        return sb.charAt(k - 1);
    }

    String reverse(StringBuilder sb) {
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l += 1;
            r -= 1;
        }

        return sb.toString();
    }

    StringBuilder invert(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0')
                sb.setCharAt(i, '1');
            else
                sb.setCharAt(i, '0');
        }

        return sb;
    }
}