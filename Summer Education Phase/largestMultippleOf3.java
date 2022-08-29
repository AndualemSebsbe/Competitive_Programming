public class largestMultippleOf3 {

    public String largestMultipleOfThree(int[] digits) {
        int sum = 0, n = digits.length;
        int[] count = new int[10];
        
        for(int digit : digits){
            sum += digit;
            count[digit]++;
        }
        
        int rem1Cnt = count[1] + count[4] + count[7];
        int rem2Cnt = count[2] + count[5] + count[8];
        int remSum = (rem1Cnt + 2*rem2Cnt)%3;
        
        if(remSum == 1){
            if(rem1Cnt >= 1) rem1Cnt -= 1;
            else
                rem2Cnt -= 2;
        }
        else if(remSum == 2){
            if(rem2Cnt >= 1) rem2Cnt -= 1;
            else
                rem1Cnt -= 2;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int d = 9; d >= 0; d--){
            if(d%3 == 0) while(count[d]-- > 0) sb.append(d);
            else if(d%3 == 1) while(count[d]-- > 0 && rem1Cnt-- > 0) sb.append(d);
            else
                while(count[d]-- > 0 && rem2Cnt-- > 0) sb.append(d);
        }
        if(sb.length() > 0 && sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}