class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int mid = s.length()/2;
        String a = s.substring(0, mid);
        String b = s.substring(mid, s.length());
        
        int firstCount = 0, secondCount = 0;
        for(int i = 0; i < mid; i++){
            if(set.contains(a.charAt(i)))
               firstCount += 1;
            if(set.contains(b.charAt(i)))
               secondCount += 1;
        }
               
     return firstCount == secondCount;          
    }
}