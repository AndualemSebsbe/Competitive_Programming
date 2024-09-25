class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for (int num : arr1)
            trie.insert(String.valueOf(num));
        
        int max = 0;
        for (int num : arr2) {
            int count = trie.search(String.valueOf(num));
            max = Math.max(max, count);
        }

        return max;
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    void insert(String nums) {
        TrieNode curr = root;
        for (char c : nums.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            
            curr = curr.children.get(c);
        }
    }

    int search(String nums) {
        TrieNode curr = root;
        int count = 0;
        for (char c : nums.toCharArray()) {
            if (!curr.children.containsKey(c))
                break;
            
            count += 1;
            curr = curr.children.get(c);
        }

        return count;
    }

    class TrieNode {
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap();
        }
    }
}