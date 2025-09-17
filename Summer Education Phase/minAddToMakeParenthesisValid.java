public class minAddToMakeParenthesisValid {

    public int minAddToMakeValid(String s) {
    
        int n = s.length(), open = 0, minAdd = 0;  
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(')
                open++;
            else{                
                    if(open > 0){
                        open--;
                    }
                    else
                        minAdd += 1;
            }
        }
        minAdd += open;
        return minAdd;
    }
}