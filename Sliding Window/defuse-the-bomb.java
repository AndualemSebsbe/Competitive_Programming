class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int sum = 0;
        int i = 1;
        int[] res = new int[n];
        if (k == 0)
            return res;
        else if (k < 0) {
            i = n - 1;
            k *= -1;
            while (k-- > 0)
                sum += code[i--];

            res[0] = sum;
            for (int idx = 1; idx < n; idx++) {
                i = (i + 1) % n;
                sum -= code[i];
                sum += code[idx - 1];
                res[idx] = sum;
            }
        }
        else {
            while (k-- > 0) 
                sum += code[i++];
            
            res[0] = sum;
            for (int idx = 1; idx < n; idx++) {
                i = i % n;
                sum -= code[idx];
                sum += code[i++];
                res[idx] = sum;
            }
        }

        return res;
    }
}