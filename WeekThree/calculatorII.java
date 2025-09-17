import java.util.Stack;

public class calculatorII {
    
        public int calculate(String s) {
            s = s.replaceAll("\\s+", "");
            String[] str = s.split("(?<=[-+*/])|(?=[-+*/])");
          //  System.out.println(Arrays.toString(str));
           // System.out.println(str[0]);
            int res=0;
            int count=0;
            String opr = "";
          
            Stack<String> st = new Stack<String>();
            if(str.length==1){
                System.out.println(s);
                res = Integer.parseInt(s);
               return res;
            }
            else
            {
            //System.out.println(Character.getNumericValue(ch[0]) * Character.getNumericValue(ch[2]));
              for(int i=0; i< str.length-1; i++ ){
                  // push char array to the stack
                     st.push(str[i]);
                     
                  if(str[i+1].equals("*") || str[i+1].equals("/") || str[i+1].equals("-") || str[i+1].equals("+")){                                 
                      count++;
                      if(count==1 && str[i+1].equals("*") || str[i+1].equals("/")){
                          count--;
                      int num1 = Integer.parseInt(st.pop());
                          //opr  = st.pop();
                          i++;
                      int num2 = Integer.parseInt(str[i+1]);
                             if(str[i].equals("*"))           
                             res= num1 * num2; 
                             if(str[i].equals("/"))           
                             res= num1 / num2;
    
                             str[i+1] = Integer.toString(res);
                      }
                      else
                      {
                      if(count==2){                     
                      if(str[i+1].equals("*") || str[i+1].equals("/")){
                          count--;
                      int num1 = Integer.parseInt(st.pop());
                          //opr  = st.pop();
                          i++;
                      int num2 = Integer.parseInt(str[i+1]);
                             if(str[i].equals("*"))           
                             res= num1 * num2; 
                             if(str[i].equals("/"))           
                             res= num1 / num2;
    
                             str[i+1] = Integer.toString(res);
                           System.out.println(str[i+1]);
                             
                     }
                     else if(str[i+1].equals("+")|| str[i+1].equals("-")){
                         count--;
                         int num2 = Integer.parseInt(st.pop());
                         opr = st.pop();
                         int num1 = Integer.parseInt(st.pop());
                         if(opr.equals("+")){
                             res = num1 + num2;
                         }
                         if(opr.equals("-")){
                             res = num1 - num2;
                         }
                         st.push(Integer.toString(res));
                         str[i] = Integer.toString(res);
                     }                  
                     }
                     }
                  }
                  if(i+1 == str.length-1){
                      if(!st.empty()){
                      opr = st.pop();
                      System.out.println(opr);
                     int num1 = Integer.parseInt(st.pop());
                      int num2 = Integer.parseInt(str[i+1]);
                      System.out.println(num1);
                      System.out.println(num2);
                      if(opr.equals("+"))
                          res = num1 + num2;
                      if(opr.equals("-"))
                          res = num1 - num2;
                      if(opr.equals("*"))
                          res = num1 * num2;
                      if(opr.equals("/"))
                          res = num1 / num2;
                      st.push(Integer.toString(res));
                      }
                      else
                      {
                          st.push(str[i+1]);
                      }
                  }
              }       
                if(!st.empty())
                 res = Integer.parseInt(st.pop());
            }      
           
            return res;
        }
    }