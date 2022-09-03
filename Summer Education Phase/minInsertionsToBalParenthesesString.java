public class minInsertionsToBalParenthesesString {

    public int minInsertions(String s) {
        int n = s.length(), open = 0, minIns = 0;  
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(')
                open++;
            else{
                if(i < n-1 && s.charAt(i+1) == ')'){
                    if(open > 0)
                        open--;
                    else
                        minIns += 1;
                    i++;
                }
                else{
                    if(open > 0){
                        open--;
                        minIns += 1;
                    }
                    else
                        minIns += 2;
                }
            }
        }
        minIns += 2*open;
        return minIns;
    }
}