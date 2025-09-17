class Solution {
    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();

        for(String word : wordDict)
            buildTrie(word);
        
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i = 0; i < n; i++){
            if(i == 0 || dp[i - 1]){
                TrieNode curr = root;
                for(int j = i; j < n; j++){
                    char c = s.charAt(j);
                    if(!curr.children.containsKey(c))
                        break;
                    
                    curr = curr.children.get(c);
                    if(curr.endOfWord)
                        dp[j] = true;
                }
            }
        }

        return dp[n - 1];
    }

    void buildTrie(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            
            curr = curr.children.get(c);
        }

        curr.endOfWord = true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode(){
        children = new HashMap();
        endOfWord = false;
    }
}