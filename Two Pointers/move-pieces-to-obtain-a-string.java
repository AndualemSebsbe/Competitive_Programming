public class Solution {

    public boolean canChange(String start, String target) {
        int startLen = start.length();
        int startIdx = 0, targetIdx = 0;

        while (startIdx < startLen || targetIdx < startLen) {
            while (startIdx < startLen && start.charAt(startIdx) == '_') {
                startIdx++;
            }
            // Skip underscores in target
            while (targetIdx < startLen && target.charAt(targetIdx) == '_') {
                targetIdx++;
            }

            if (startIdx == startLen || targetIdx == startLen) {
                return startIdx == startLen && targetIdx == startLen;
            }

            if (start.charAt(startIdx) != target.charAt(targetIdx) ||
                    (start.charAt(startIdx) == 'L' && 
                    startIdx < targetIdx) || 
                    (start.charAt(startIdx) == 'R' && 
                    startIdx > targetIdx))
                return false;

            startIdx++;
            targetIdx++;
        }

        return true;
    }
}