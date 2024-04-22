class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet(Arrays.asList(deadends));
        if(visited.contains("0000"))
            return -1;
            
        Queue<String> q = new LinkedList();
        q.add("0000");
        int turns = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                String lock = q.poll();
                if(lock.equals(target))
                    return turns;

                for(String child : children(lock)){
                    if(!visited.contains(child)){
                        q.add(child);
                        visited.add(child);
                    }
                }
            }

            turns += 1;
        }

        return -1;
    }

    List<String> children(String lock){
        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder(lock);
        for(int i = 0; i < 4; i++){
            char c = sb.charAt(i);
            String s1 = sb.substring(0, i) + 
                (c == '9' ? 0 : c - '0' + 1) + sb.substring(i+1);
            String s2 = sb.substring(0, i) + 
                (c == '0' ? 9 : c - '0' - 1) + sb.substring(i+1);
            res.add(s1);
            res.add(s2);
        }

        return res;
    }
}