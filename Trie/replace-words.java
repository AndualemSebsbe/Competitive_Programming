class Solution {
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for(String dic : dictionary)
            buildTrie(dic);
        
        String[] words = sentence.split(" ");
        int n = words.length;
        String res = "";
        for(int i = 0; i < n; i++){
            res += searchTrie(words[i]);
            if(i != n - 1)
                res += " ";
        }

        return res;
    }

    String searchTrie(String word){
        TrieNode curr = root;
        String s = "";
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c))
                return word;
            
            curr = curr.children.get(c);
            s += c;
            if(curr.endOfWord)
                return s;
        }

        return word;
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

    public TrieNode() {
        children = new HashMap();
        endOfWord = false;
    }
}