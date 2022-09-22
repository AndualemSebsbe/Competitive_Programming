public class revWordsII {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        String rev = "";
        for(String word : str){
            rev += reverse(word) + " ";
        }
        
        return rev.substring(0, s.length());
    }
    
    public String reverse(String word){
        char[] rev = word.toCharArray();

        int l = 0, r = word.length()-1; 
        while(l < r){
            char temp = rev[l];
            rev[l] = rev[r];
            rev[r] = temp;
            l++; r--;
        }
        return String.valueOf(rev);
    }
}