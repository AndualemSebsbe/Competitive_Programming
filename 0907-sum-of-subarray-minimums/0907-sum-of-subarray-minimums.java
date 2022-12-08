class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = 1000000007;
        int left = 0, mid = 0;
        long res = 0, count = 0;
        Stack<Integer> st = new Stack();
        
        for(int i = 0; i <= n; i++){
            while(!st.empty() && (i == n || arr[i] < arr[st.peek()])){
                mid = st.pop();
                left = st.empty() ? -1 : st.peek();
                
                count = (mid - left)*(i - mid)%mod;
                res += arr[mid]*count%mod;
                res %= mod;
            }
            st.push(i);
        }
        
        return (int)res;
    }
}