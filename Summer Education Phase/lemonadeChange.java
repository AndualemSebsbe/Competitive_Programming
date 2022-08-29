public class lemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int countFives = 0, countTens = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
            countFives++;
        }
        else if(bills[i] == 10){
            if(countFives > 0){
                countFives--;
                countTens++;
            }
            else
                return false;
        }
        else if(bills[i] == 20){
            if(countFives > 0 && countTens > 0){
                countFives--;
                countTens--;
            }
            else if(countFives >= 3){
                countFives -= 3;
            }
            else
                return false;
            }
        }
        return true;
    }
}