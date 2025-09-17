import java.util.Stack;

class basicCalculator {
    public int calculate(String s) {
        int n = s.length();
        int res = 0, sign = 1;
        int currNum = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            if(Character.isDigit(s.charAt(i))){
                currNum = s.charAt(i) - '0';
                while(i+1 < n && Character.isDigit(s.charAt(i+1))){
                    currNum = currNum * 10 + s.charAt(i+1) - '0';
                    i += 1;
                }
                currNum = sign*currNum;
                res += currNum;
                currNum = 0;
            }
            else if(s.charAt(i) == '+')
                sign = 1;
            else if(s.charAt(i) == '-')
                sign = -1;
            else if(s.charAt(i) == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                int prevSign = st.pop();
                res = prevSign * res;
                int prevRes = st.pop();
                res += prevRes;
            }     
        }
        return res;
    }
}