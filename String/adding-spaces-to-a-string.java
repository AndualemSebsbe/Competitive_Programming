class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        for (int i = 0; i < spaces.length; i++) {
            for (int j = start; j < spaces[i]; j++)
                sb.append(s.charAt(j));
            sb.append(" ");
            start = spaces[i];
        }

        for (int i = start; i < s.length(); i++)
            sb.append(s.charAt(i));

        return sb.toString();
    }
}