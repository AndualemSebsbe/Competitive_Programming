public class longestWordInDictionary {

    TrieNode root;
    
    public String longestWord(String[] words) {
        root = new TrieNode('\0');
        for(String word : words)
            insert(word);
        
        String answer = "";
        for(String word : words){
            if(word.length() < answer.length() || (word.length() == answer.length() && word.compareTo(answer) > 0)){
                continue;
            }
                
            if(findLongestWord(word))
                answer = word;
        }
        
        return answer;
    }
    
    public void insert(String word){
        
            TrieNode curr = root;
            for(char w : word.toCharArray()){
                int indx = w - 'a';
                if(curr.kids[indx] == null) curr.kids[indx] = new TrieNode(w);
                curr = curr.kids[indx];
            }
            curr.isEndOfWord = true;        
    }
    
    public boolean findLongestWord(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int indx = c - 'a';
            if(curr.kids[indx] == null)
                return false;
            curr = curr.kids[indx];
            if(!curr.isEndOfWord)
                return false;
            
        }
        return true;
    }
    
    class TrieNode{
        char c;
        TrieNode[] kids;
        boolean isEndOfWord;
        
        TrieNode(char c){
            this.c = c;
            kids = new TrieNode[26];
            isEndOfWord = false;
        }
    }
}

