class LockingTree {
    Map<Integer, List<Integer>> tree;
    Map<Integer, Integer> locked;
    int[] parent;
    public LockingTree(int[] parent) {
        tree = new HashMap();
        locked = new HashMap();
        this.parent = parent;
        for(int i = 0; i < parent.length; i++){
            if(!tree.containsKey(parent[i]))
                tree.put(parent[i], new ArrayList());
            tree.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num))
            return false;
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num) || locked.get(num) != user)
            return false;
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        int curr = num;
        while(curr != -1){
            if(locked.containsKey(curr))
                return false;
            curr = parent[curr];
        }

        int size = locked.size();
        dfs(num);
        if(size == locked.size())
            return false;
        locked.put(num, user);
        return true;
    }

    void dfs(int num){
        if(locked.containsKey(num))
            locked.remove(num);
        if(tree.containsKey(num)){
            for(int child : tree.get(num))
                dfs(child);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */