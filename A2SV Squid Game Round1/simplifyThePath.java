import java.util.Stack;

class simplifyThePath{
    public String simplifyPath(String path) {
         Stack<String> st = new Stack<>();
         StringBuilder res = new StringBuilder();
         String[] p = path.split("/");
         
         for(int i = 0; i < p.length; i++){
           if(p[i].equals("..")){
              if(!st.empty()) 
                  st.pop();
           }
           else if(!p[i].equals("") && !p[i].equals(".")){
             st.push(p[i]);
           }
         }
         
         if(st.isEmpty()) 
          return "/";
         while(!st.isEmpty()){
           res.insert(0,st.pop()).insert(0,"/");
         }
         return res.toString();
      }
  }