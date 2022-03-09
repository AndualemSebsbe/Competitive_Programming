class break_Palindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
       
        char[] char_array = palindrome.toCharArray();
        int len =char_array.length;
    
        for(int i = 0; i < len; i++){
            for(char c='a'; c < 'z'; c++){
                if(char_array[i] == c) break;
                if(i == len/2)
                    char_array[len - 1] = 'b';
                else
                    char_array[i] = c;
                String newWord = String.valueOf(char_array);
                return newWord;
            }            
        }
        if(char_array[len - 1] == 'a')
            char_array[len - 1] = 'b';
        String word1 = String.valueOf(char_array);
        return word1;
    }
}