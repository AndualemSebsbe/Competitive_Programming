class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs)
            trie.insert(str);

        return trie.search(strs[0], strs.length);
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
            curr.wordCount += 1;
        }
    }

    String search(String word, int n) {
        TrieNode curr = root;
        String res = "";
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c) || curr.children.get(c).wordCount < n)
                break;

            curr = curr.children.get(c);
            res += c;
        }

        return res;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        int wordCount;

        public TrieNode() {
            children = new HashMap();
            wordCount = 0;
        }
    }
}