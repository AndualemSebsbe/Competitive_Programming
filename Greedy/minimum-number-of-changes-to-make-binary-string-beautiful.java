class Solution {

    public int minChanges(String s) {
        char curChar = s.charAt(0);

        int consecutiveCount = 0;
        int minChangesReq = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curChar) {
                consecutiveCount++;
                continue;
            }

            if (consecutiveCount % 2 == 0)
                consecutiveCount = 1;
            else {
                consecutiveCount = 0;
                minChangesReq++;
            }

            curChar = s.charAt(i);
        }

        return minChangesReq;
    }
}