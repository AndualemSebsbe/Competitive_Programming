import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        int len = piles.length;
        int n = len/3;
        // sort the array O(nlogn)
        Arrays.sort(piles);
        int sumOfCoins = 0;
        // Iteration starts from n because the num of coins
        // from index 0 to n-1 will be given to bob
        // which is the smallest to the array piles
        for(int i=n; i<len; i+=2){
            sumOfCoins += piles[i];
        }
        return sumOfCoins;
    }
}