class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge : edges){
            if(!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList());
            map.get(edge[0]).add(edge[1]);

            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList());
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        visited.add(source);

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                int cur = queue.poll();
                if(cur == destination)
                    return true;

                if(map.containsKey(cur)){
                    for(int child : map.get(cur)){
                        if(!visited.contains(child)){
                            queue.add(child);
                            visited.add(child);
                        }
                    }
                }
            }
        }

        return false;
    }
}