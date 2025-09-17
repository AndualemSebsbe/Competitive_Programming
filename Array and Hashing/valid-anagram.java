class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if(m != n)
            return false;

        int[] store = new int[26];
        for(int i = 0; i < n; i++){
            store[s.charAt(i) - 'a'] += 1;
            store[t.charAt(i) - 'a'] -= 1;
        }

        for(int val : store){
            if(val != 0)
                return false;
        }

        return true;
    }
}