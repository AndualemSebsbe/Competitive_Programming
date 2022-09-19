import java.util.ArrayList;
import java.util.List;

class numbersWithSameSequencesDiff {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> queue = new ArrayList();
        for(int i = 1; i <= 9; i++) queue.add(i);
        
        for(int level = 1; level < n; level++){
          List<Integer> nextQueue = new ArrayList();
          for(Integer num : queue){
              int tailDigit = num % 10;
              
              List<Integer> nextDigits = new ArrayList();
              nextDigits.add(tailDigit+k);
              if(k != 0)
                  nextDigits.add(tailDigit-k);
              
              for(Integer nextDigit : nextDigits){
                  if(0 <= nextDigit && nextDigit < 10){
                      int newNum = num * 10 + nextDigit;
                      nextQueue.add(newNum);
                  }
              }
          }
          queue = nextQueue;
        }
        
        int[] ans = new int[queue.size()];
        int i = 0;
        for(Integer q : queue)
            ans[i++] = q;
        return ans;
    }
}