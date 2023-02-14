class minimumDeletionsToBalance {
    public int minimumDeletions(String s) {
        int minA = 0, minB = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'b')
                minA += 1;
            else
                minB = Math.min(1+minB, minA);
        }

        return minB;
    }
}