class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        for (int start = 1; start <= 9; start++)
            dfs(res, start, n);

        return res;
    }

    void dfs(List<Integer> res, int num, int n) {
        if (num > n)
            return;

        res.add(num);

        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNum = num * 10 + nextDigit;
            dfs(res, nextNum, n);
        }
    }
}