class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> count = new HashMap();
        for(String word : words){
            for(char c : word.toCharArray())
                count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int n = words.length;
        for(char c : count.keySet()){
            int val = count.get(c);
            if(val % n != 0)
                return false;
        }
        return true;
    }
}