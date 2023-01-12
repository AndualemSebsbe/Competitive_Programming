import java.util.Stack;

class usingRobot {
	public String robotWithString(String s) {
		int startingIndex = 0;
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(char c = 'a'; c <= 'z'; c++){
			while(stack.size() > 0 && stack.peek() <= c){
				sb.append(stack.pop());
			}

			for(int j = startingIndex; j < s.length(); j++){
				if(s.charAt(j) == c){
					for(int k = startingIndex; k <= j; k++)
						stack.add(s.charAt(k));
					                  
					sb.append(stack.pop());
					startingIndex = j+1;;
				}
			}
		}

		return sb.toString();
	}
}