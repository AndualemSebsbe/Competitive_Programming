package PostCamp;

class addingSpacesToString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = spaces.length;

        if(spaces[0] == 0)
            sb.append(" ");
        else{
            sb.append(s.substring(0, spaces[0]));
            sb.append(" ");
        }

        for(int i = 1; i < n; i++){
            sb.append(s.substring(spaces[i-1], spaces[i]));
            sb.append(" ");
        }

        sb.append(s.substring(spaces[n-1], s.length()));

        return sb.toString();
    }
}