class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int MAX = 100000;
        int N = nums.length;
        Set<Integer> set = new HashSet();
        for (int num : nums)
            set.add(num);

        // edge cases
        if (N == 1)
            return true;

        if (set.contains(1))
            return false;

        int[] sieve = new int[MAX + 1];
        for (int d = 2; d <= MAX; d++) {
            if (sieve[d] == 0) {
                for (int v = d; v <= MAX; v += d) {
                    sieve[v] = d;
                }
            }
        }

        UnionFind uf = new UnionFind(2 * MAX + 1);
        for (int num: nums) {
            int val = num;
            while (val > 1) {
                int prime = sieve[val];
                int root = prime + MAX;
                if (uf.find(root) != uf.find(num))
                    uf.union(root, num);

                while (val % prime == 0)
                    val /= prime;
            }
        }

        int count = 0;
        for (int i = 2; i <= MAX; i++) {
            if (set.contains(i) && uf.find(i) == i)
                count += 1;
        }
        return count == 1;
    }
}
class UnionFind {
    public int[] par;
    public int[] size;

    public UnionFind(int N) {
        par = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            par[i] = i;
            size[i] = 1;
        }
    }
    public int find(int num) {
        return par[num] == num ? num : (par[num] = find(par[num]));
    }

    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 == p2)
            return;

        if (size[p1] > size[p2]) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }

        par[p1] = p2;
        size[p2] += size[p1];
    }
}