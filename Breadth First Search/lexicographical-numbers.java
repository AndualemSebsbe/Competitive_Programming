class Solution {
    Map<Integer, List<Integer>> graph = new HashMap();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= n; i++) {
            int par = i / 10;
            if (par != 0) {
                if (!graph.containsKey(par))
                    graph.put(par, new ArrayList());
                graph.get(par).add(i);
            }
        }

        List<Integer> res = new ArrayList();
        for (int i = 1; i <= n && i <= 9; i++) {
            dfs(res, i);
        }

        return res;
    }

    void dfs(List<Integer> res, int num) {
        res.add(num);
        if (graph.containsKey(num)) {
            for (int child : graph.get(num)) {
                dfs(res, child);
            }
        }
    }
}