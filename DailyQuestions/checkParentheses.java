class checkParentheses {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0) return false;
        
       int closeParentheses = 0 , openParentheses = 0, flipAllowed = 0;
       for(int i = 0; i < s.length() - 1; i++){
           if(locked.charAt(i) == '0')
               flipAllowed++;
           else{
               if(s.charAt(i) == '(')
                   openParentheses++;
               else if(s.charAt(i) == ')')
                   closeParentheses++;
           }
           
           if((flipAllowed + openParentheses) < closeParentheses)
               return false;
       }
       
       closeParentheses = openParentheses = flipAllowed = 0;
        
       for(int i = s.length() - 1; i >= 0; i--){
           if(locked.charAt(i) == '0')
               flipAllowed++;
           else{
               if(s.charAt(i) == '(')
                   openParentheses++;
               else if(s.charAt(i) == ')')
                   closeParentheses++;
           }
           
           if((flipAllowed + closeParentheses) < openParentheses)
               return false;
       }
        return true;
    }
}