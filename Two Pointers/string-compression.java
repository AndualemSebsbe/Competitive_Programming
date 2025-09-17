class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        int i = 0;
        while(i < n){
            int j = i;
            while(j < n && chars[j] == chars[i])
                j += 1;

            chars[idx++] = chars[i];
            if(j - i > 1){
                String count = j - i + "";
                for(char c : count.toCharArray())
                    chars[idx++] = c;
            }

            i = j;
        }

        return idx;
    }
}