class regexMatch {
  
  static boolean isMatch(String text, String pattern) {
    // your code goes here
    return isMatched(text, 0, pattern, 0);
  }
  
  static boolean isMatched(String text, int i, String pattern, int j){
    if(text.length() == i && pattern.length() == j)
      return true;
    if(text.length() >= i || pattern.length() >= j)
      return false;
    
    if(text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')
      return isMatched(text, i+1, pattern, j+1);
    else if(pattern.charAt(j) == '*'){
      if(text.charAt(i) == pattern.charAt(j-1))
        return isMatched(text, i+1, pattern, j);
      else if(text.charAt(i) != pattern.charAt(j-1))
        return isMatched(text, i, pattern, j+1);
    }
    else
      return false;
    
   return true;
  }

  public static void main(String[] args) {
    
  }

}
/*
text = 'aa' pattern = 'a'

text = "abc", pattern = "a.c"

text = "abbb", pattern = "ab*"


*/
