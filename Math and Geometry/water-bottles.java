class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = 0, count = 0;
        while(numBottles != 0){
            count += numBottles;
            emptyBottles += numBottles;
            numBottles = (emptyBottles / numExchange);
            emptyBottles = (emptyBottles % numExchange);
        }

        return count;
    }
}