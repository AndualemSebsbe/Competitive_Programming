class Solution {
    Map<Integer, List<Integer>> graph = new HashMap();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= n; i++) {
            int par = i / 10;            
            if (!graph.containsKey(par))
                graph.put(par, new ArrayList());
            graph.get(par).add(i);
        }

        List<Integer> res = new ArrayList();
        dfs(res, 0);

        return res;
    }

    void dfs(List<Integer> res, int num) {
        if (num != 0)
            res.add(num);
            
        if (graph.containsKey(num)) {
            for (int child : graph.get(num)) {
                dfs(res, child);
            }
        }
    }
}