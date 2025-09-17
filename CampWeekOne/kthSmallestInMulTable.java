public class kthSmallestInMulTable {

        public int findKthNumber(int m, int n, int k) {
           int l = 1, r = m*n;
            while(l <= r){
                int mid = l + (r - l)/2;
                if(smallest(mid, n, k, m))
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }
        
        private boolean smallest(int mid, int n, int k, int m){
            int count = 0;
            for(int i=1; i<=m; i++)
                count += Math.min(mid/i, n);
            return count >= k;
        }
    }