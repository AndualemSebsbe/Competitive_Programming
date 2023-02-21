import java.util.Deque;
import java.util.ArrayDeque;

public class miniParser {
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger cur = new NestedInteger();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '['){
                stack.push(cur);
                cur = new NestedInteger();
            }else if (ch == '-' || Character.isDigit(ch)){
                int j = i + 1;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    ++j;
                }
                cur.add(parse(i, j, s));
                i = j - 1;
            }else if (ch == ']'){
                stack.peek().add(cur);
                cur = stack.pop();
            }
        }
        return cur.getList().get(0);
    }

    private NestedInteger parse(int lo, int hi, String s){
        return new NestedInteger(Integer.parseInt(s.substring(lo, hi)));
    }
}

public class NestedInteger{
    
}