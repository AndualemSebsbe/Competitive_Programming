class Solution {
    public String reverseVowels(String s) {
        String vowelStr = "";
        char[] ch = s.toCharArray();
        for(char c : ch)
            if(isVowel(c))
                vowelStr += c;
        
        int j = vowelStr.length()-1;
        for(int i = 0; i < ch.length; i++)
            if(isVowel(ch[i]))
                ch[i] = vowelStr.charAt(j--);
        
        return String.valueOf(ch);
    }
    
    public boolean isVowel(char c){
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
           c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        
        return false;
    }
}