import java.nio.file.attribute.PosixFileAttributeView;

import javax.sound.sampled.SourceDataLine;

class reverseVowelOfString {
    public String reverseVowels(String s) {
    
        int l = 0, r = s.length()-1;
        char[] ch = s.toCharArray();
        boolean lVowel = false, rVowel = false;
        while(l < r){
            if(isVowel(ch[l]))
               lVowel = true;
            else{
                lVowel = false;
                l++;
            }
            
            if(isVowel(ch[r]))
                 rVowel = true;
            else{
                 r--;
                 rVowel = false;
             }
            
            if(lVowel && rVowel){
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++; r--;
            }
            
        }
        return String.valueOf(ch);
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'i' || c == 'o' || c == 'e' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}