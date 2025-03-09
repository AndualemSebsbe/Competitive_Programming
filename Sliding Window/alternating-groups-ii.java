public class Solution {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        // Extend the array to handle circular sequences
        for (int i = 0; i < colors.length; i++)
            extendedColors[i] = colors[i];
        
        for (int i = 0; i < k - 1; i++)
            extendedColors[colors.length + i] = colors[i];

        int len = extendedColors.length;
        int res = 0;
        int left = 0;
        int right = 1;

        while (right < len) {
            if (extendedColors[right] == extendedColors[right-1]) {
                left = right;
                right += 1;
                continue;
            }

            right += 1;

            if (right - left < k) 
                continue;

            res += 1;
            left += 1;
        }

        return res;
    }
}