class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = words.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i ++) {
            int count = trie.search(words[i]);
            res[i] = count;
        }

        return res;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            
            curr = curr.children.get(c);
            curr.count += 1;
        }

        curr.isEndOfWord = true;
    }

    int search(String word) {
        TrieNode curr = root;
        int count = 0;
        for (char c : word.toCharArray()) {
            curr = curr.children.get(c);
            count += curr.count;
        } 

        return count;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        int count;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap();
            count = 0;
            isEndOfWord = false;
        }
    }
}