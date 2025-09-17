class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList();
        combSum2(list, candidates, 0, target);

        return res;
    }

    void combSum2(List<Integer> list, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList(list));
            return;
        }

        if (target < 0)
            return;
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            
            list.add(candidates[i]);
            combSum2(list, candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}