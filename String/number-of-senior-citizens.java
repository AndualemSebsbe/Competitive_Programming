class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail : details){
            int firstDigit = detail.charAt(11) - '0';
            int secondDigit = detail.charAt(12) - '0';
            int age = firstDigit * 10 + secondDigit; 
            if(age > 60)
                count += 1;
        }

        return count;
    }
}