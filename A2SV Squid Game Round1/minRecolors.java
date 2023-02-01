class minRecolors {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int leftCount = 0;
        for(int i = 0; i < k; i++)
            if(blocks.charAt(i) == 'W')
                leftCount += 1;
        
        int min = leftCount;
        for(int i = k; i < n; i++){
            if(blocks.charAt(i-k) == 'W')
                leftCount -= 1;
            if(blocks.charAt(i) == 'W')
                leftCount += 1;
            min = Math.min(min, leftCount);
        }

        return min;
    }
}