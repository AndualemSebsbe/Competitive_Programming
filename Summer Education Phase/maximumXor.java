public class maximumXor {

    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        root = new TrieNode();
        buildTrie(nums);
        
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            int maxXor = findMaxXor(num);
            max = Math.max(maxXor, max);
        }
        
        return max;
    }
    
    public void buildTrie(int[] nums){
        
        for(int num : nums){
            TrieNode curr = root;
            
            for(int i = 31; i >=0; i--){
                int currBit = (num >>> i) & 1;
                if(curr.kids[currBit] == null) curr.kids[currBit] = new TrieNode();
                curr = curr.kids[currBit];
            }
        }
    }
    
    public int findMaxXor(int num){
        TrieNode curr = root;
        int ans = 0;
        for(int i = 31; i>= 0; i--){
            int currBit = (num>>>i) & 1;
            if(currBit == 1){
                if(curr.kids[0] != null){
                    ans += (1<<i);
                    curr = curr.kids[0];
                }
                else{
                    curr = curr.kids[1];
                }
            }
            else{
                if(curr.kids[1] != null){
                    ans += (1<<i);
                    curr = curr.kids[1];
                }
                else{
                    curr = curr.kids[0];
                }
            }
        }
        return ans;
    }
    
    class TrieNode{
        TrieNode[] kids;
        public TrieNode(){
            kids = new TrieNode[2];
        }
    }
}