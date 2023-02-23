import java.util.HashMap;
import java.util.Map;

class longestArthmeticSubsequence {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        int n = A.length;
        Map<Integer, Integer> s = new HashMap<>();
        s.put(A[0], 1);
        map.put(0, s);
        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> cur = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                cur.put(diff, 2);
                Map<Integer, Integer> pre = map.get(j);
                if (pre.containsKey(diff)) {
                    cur.put(diff, pre.get(diff) + 1);
                }
                res = Math.max(cur.get(diff), res);
            }
            map.put(i, cur);
        }
        return res;
    }
}