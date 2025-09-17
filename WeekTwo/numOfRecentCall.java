import java.util.ArrayList;
import java.util.Iterator;

class RecentCounter {
    
     
    // Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> queue = new ArrayList<>();
   public RecentCounter() {  
       
   }
   
   public int ping(int t) {
       int request = 0;
       queue.add(t);
      
       int[][] range = new int[1][2];
       range[0][0] = t - 3000;
       range[0][1] = t;
       
       Iterator iterator = queue.iterator();
while(iterator.hasNext()){
  
   int item = (Integer)iterator.next();
    if(item >= range[0][0]){
                //queue.add(item);
               request++;
              
           }
           else {
               
               iterator.remove();
                
              // request--;
           }
       
}
         return request;
   }
}
       

/**
* Your RecentCounter object will be instantiated and called as such:
* RecentCounter obj = new RecentCounter();
* int param_1 = obj.ping(t);
*/