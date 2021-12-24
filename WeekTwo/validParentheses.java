import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int len=s.length();
        boolean balanced=false;
        Stack<Character> s1 = new Stack<Character>();
        char top;
          for(char ch: s.toCharArray()){
              if(ch=='{' || ch=='[' || ch=='('){
                  s1.push(ch);
              }
              else
              {
                  if(s1.empty()){
                      balanced=false;
                      return balanced;
                  }
                  else{
                      top=(Character) s1.peek();
                      if(ch==')' && top=='(' || ch==']' && top=='['                          || ch=='}' && top=='{'){
                          s1.pop();
                      }
                      else
                      {
                         balanced=false;
                          return balanced;
                      }
                  }
              }
          }
        if(s1.empty()){
            balanced=true;
        }
        else{
            balanced=false;
        }
        return balanced;
    }
}