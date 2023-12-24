class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '1')
                    count += 1;
            }
            else{
                if(s.charAt(i) == '0')
                    count += 1;
            }
        }

        return Math.min(count, n - count);
    }
}