public class minOperationsToConvertTime {

    public int convertTime(String current, String correct) {
        String[] currStr = current.split(":"), corrStr = correct.split(":");

        int currMin = Integer.parseInt(currStr[0])*60 + Integer.parseInt(currStr[1]);
        int corrMin = Integer.parseInt(corrStr[0])*60 + Integer.parseInt(corrStr[1]);
        
        int diff = corrMin - currMin, i = 0, count = 0;
        int[] minutes = {60,15,5, 1};
        
        while(i < 4){
            count += diff/minutes[i];
            diff%= minutes[i];
            i++;
        }
        
        return count;
    }
}