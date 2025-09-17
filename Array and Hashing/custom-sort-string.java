class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                int val = map.get(c);
                while(val-- > 0){
                    sb.append(c);
                }
            }
        }

        Set<Character> set = new HashSet();
        for(char c : order.toCharArray())
            set.add(c);
        for(char c : s.toCharArray()){
            if(!set.contains(c))
                sb.append(c);
        }

        return sb.toString();
    }
}