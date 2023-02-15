import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class numOfSquarefulArrays {
    private boolean isSquare(int a, int b){
        double sqr = Math.sqrt(a+b);
        boolean res = (sqr - Math.floor(sqr)) == 0;
        return res;
    }
    
    int count = 0;
    void helper(List<Integer> temp, int[] A, boolean[] used, int lastNumber){
        if (temp.size() == A.length){
            count++;
        } else {
            for (int i = 0; i < A.length;i++){
                if (used[i] || (i > 0 && A[i] == A[i-1] && !used[i-1]))
                    continue;
                if (lastNumber != -1){
                    if (isSquare(A[i],lastNumber) == false)
                        continue;
                }
                
                used[i] = true;
                temp.add(A[i]);
                helper(temp,A,used,A[i]);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
        
    }
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList<>(), nums, new boolean[nums.length], -1);
        return count;
    }
}