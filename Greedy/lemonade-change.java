class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFives = 0, countTens = 0;
        for (int bill : bills) {
            if (bill == 5)
                countFives += 1;
            else if (bill == 10) {
                if (countFives == 0)
                    return false;

                countFives -= 1;
                countTens += 1;
            }
            else {
                if (countFives == 0)
                    return false;
                else if (countTens == 0) {
                    if (countFives < 3)
                        return false;
                    countFives -= 3;
                } 
                else {
                    countFives -= 1;
                    countTens -= 1;
                }
            }
        }

        return true;
    }
}