public class decodeStr {

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int loop = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
                loop = loop*10 + ch - '0';
            else if(Character.isLetter(ch))
                ans.append(ch);
            else if(ch == '['){
                String res = "";
                
                res = decodeString(s.substring(i+1));
                for(int j = 0; j < loop; j++) ans.append(res);
                
                int count = 1;
                while(count != 0){
                    i++;
                    if(s.charAt(i) == '['){
                        count++;
                    }
                    else if(s.charAt(i) == ']'){
                        count--;
                    }
                }
                loop = 0;
            }
            else if(ch == ']'){
                break;
            }
        }
        return ans.toString();  
    }
    }
