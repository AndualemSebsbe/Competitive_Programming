class implementTrie {
    TrieNode root;
    
    public implementTrie() {
        root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
           int indx = word.charAt(i) - 'a';
            if(curr.kids[indx] == null) curr.kids[indx] = new TrieNode(word.charAt(i));
            curr = curr.kids[indx];
        }
        
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = getNode(word);
        
        return (node != null) && (node.isEndOfWord == true);
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    public TrieNode getNode(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int indx = word.charAt(i) - 'a';
            if(node.kids[indx] == null) return null;
            node = node.kids[indx];
        }
        
        return node;
    }
    
    class TrieNode{
        char c;
        boolean isEndOfWord;
        TrieNode[] kids;
        
        public TrieNode(char c){
            this.c = c;
            isEndOfWord = false;
            kids = new TrieNode[26];
        }
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */