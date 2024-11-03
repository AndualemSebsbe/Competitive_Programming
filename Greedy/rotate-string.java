class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length(), m = goal.length();
        int start = 0, lastIdx = 0;
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            int idx = 0;
            for (int j = i; j < n; j++) {
                if (idx < m && s.charAt(j) != goal.charAt(idx)) {
                    isValid = false;
                    break;
                }
                
                idx += 1;
            }

            if (isValid) {
                start = i;
                lastIdx = idx;
            }
        }

        if (start == 0) {
            for (int i = 0; i < n; i++) {
                if (i >= m)
                    return false;
                    
                if (i < m && s.charAt(i) != goal.charAt(i))
                    return false;
            }
        }

        for (int i = 0; i < start; i++) {
            if (lastIdx >= m)
                return false;

            if (lastIdx < m && s.charAt(i) != goal.charAt(lastIdx))
                return false;
            lastIdx += 1;
        }

        return true;
    }
}