class countWordswithGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int n = pref.length();
        for(String word : words){
            if(word.length() < n)
                continue;
            if(word.substring(0, n).equals(pref))
                count += 1;
        }

        return count;
    }
}