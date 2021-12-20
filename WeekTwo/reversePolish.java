import java.util.HashSet;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<String>();
        int st1=0;
        Integer s2=0;
        int z=0;
         HashSet<String> set=new HashSet();  
           set.add("+");    
           set.add("-");    
           set.add("*");   
           set.add("/");  
        for(String s : tokens){
        
            if (set.contains(s)){
                // System.out.println(s);
                int x = Integer.parseInt(st.pop());
                  int y = Integer.parseInt(st.pop());
                    
                    if(s.equals("+")){
                    z = y + x;
                    }
                    else if(s.equals("-")){
                     z = y - x;
                    }
                    else if(s.equals("*")){
                        z = y * x;
                    }
                    else if(s.equals("/")){
                        z = y / x;
                    }
                  String z1 = Integer.toString(z);
                  st.push(z1);
                
            }
            else
            {
               st.push(s);   
            }            
        }
        
        if (!st.isEmpty()){
            s2 = Integer.parseInt(st.pop());
        }
        System.out.println(s2);
        
        st1 = Integer.valueOf(s2);
        return st1;
    }
   
}
