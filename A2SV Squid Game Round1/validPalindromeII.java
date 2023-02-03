class validPalindromeII {
    public boolean validPalindrome(String s) {
        if(isPalindrome(s))
            return true;

        return delOneChar(s);
    }

    boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;

        while(l < r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }

        return true;
    }

    boolean delOneChar(String s){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int n = s.length();
        int l = 0, r = n-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                s1.append(s.substring(0, l));
                s1.append(s.substring(l+1, n));

                s2.append(s.substring(0, r));
                s2.append(s.substring(r+1, n));
                break;
            }
            l += 1; r -= 1;
        }

        return isPalindrome(s1.toString()) || 
                isPalindrome(s2.toString());
    }
}