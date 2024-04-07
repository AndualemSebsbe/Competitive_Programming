class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> open = new Stack();
        Stack<Integer> stars = new Stack();
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(')
                open.add(i);
            else if(c == ')'){
                if(!open.isEmpty())
                    open.pop();
                else if(!stars.isEmpty())
                    stars.pop();
                else
                    return false;
            }
            else
                stars.add(i);
        }

        while(!open.isEmpty()){
            if(stars.isEmpty() || stars.peek() < open.peek())
                return false;
            
            stars.pop();
            open.pop();
        }

        return true;
    }
}