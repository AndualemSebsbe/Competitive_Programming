class Solution {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        Collections.reverse(list);
        int n = list.size();
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int[] idxes = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(i) > max) {
                max = list.get(i);
                maxIdx = i;
            }

            idxes[i] = maxIdx;
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i) < list.get(idxes[i])) {
                int temp = list.get(i);
                list.set(i, list.get(idxes[i]));
                list.set(idxes[i], temp);
                break;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++)
            res = res * 10 + list.get(i);
        
        return res;
    }
}