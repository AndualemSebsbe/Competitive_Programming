class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size() > k)
                    maxHeap.poll();
            }
        }
        return maxHeap.peek();
        // int row = matrix.length;
        // int col = matrix[0].length;
        // int l = matrix[0][0];
        // int r = matrix[row-1][col-1];
        // while(l <= r){
        //     int mid = l + (r-l)/2;
        //     int count = counter(matrix, mid);
        //     if(count < k) l = l + 1;
        //     else
        //         r = mid - 1;
        // }
        // return l;
    }
    // public int counter(int[][] matrix, int target){
    //     int len = matrix.length, i = len - 1, j = 0, cnt = 0;
    //     while(i >= 0 && j < len){
    //         if(matrix[i][j] > target) i--;
    //         else{
    //             cnt = cnt + i + 1;
    //             j++;
    //         }
    //     }
    //     return cnt;
    // }
}