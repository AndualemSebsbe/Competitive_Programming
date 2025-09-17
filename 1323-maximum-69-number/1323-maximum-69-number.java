class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList();
        while(num > 0){
            int rem = num % 10;
            list.add(rem);
            num /= 10;
        }
        
        int flag = 1;
        int res = 0;
        for(int i = list.size()-1; i >= 0; i--){
            if(flag == 1 && list.get(i) == 6){
                res = res*10 + 9;
                flag = 0;
            }
            else
                res = res*10 + list.get(i);
        }
        
        return res;
    }
}