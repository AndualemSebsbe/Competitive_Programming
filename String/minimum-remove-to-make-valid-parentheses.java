class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0, n = s.length();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            sb.append(c);
            if(c == ')')
                open -= 1;
            else if(c == '(')
                open += 1;

            if(open < 0){
                sb.deleteCharAt(sb.length() - 1);
                open += 1;
            }
        }

        int r = sb.length() - 1;
        while(open > 0){
            if(sb.charAt(r) == '('){
                sb.deleteCharAt(r);
                open -= 1;
            }

            r -= 1;
        }

        return sb.toString();
    }
}