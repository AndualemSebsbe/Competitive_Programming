package AfterCamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class findSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // Integer[] num = new Integer[n];
        
        Queue<Integer> queue = new LinkedList<>();
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] outgoing = new int[n];
        
        int indx = 0, src = 0, dst = 0;
        for(int[] g : graph){
            src = indx++;
            for(int j = 0; j < g.length; j++){
                dst = g[j];
                outgoing[src] += 1;
               // map.computeIfAbsent(dst, l -> new ArrayList()).add(src);
                if(!map.containsKey(dst)){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(src);
                    map.put(dst, list1);
                }
                else{
                    map.get(dst).add(src);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(outgoing[i] == 0)
                queue.add(i);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        while(queue.size() > 0){
            int curr = queue.remove();
            list.add(curr);
            List<Integer> aList = map.get(curr);
            for(int i = 0; aList != null && i < aList.size(); i++){
                outgoing[aList.get(i)] -= 1;
                if(outgoing[aList.get(i)] == 0)
                    queue.add(aList.get(i));
            }
        }
        
        int size = list.size();
        // System.out.println(size);
        int[] arr = new int[size];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        Arrays.sort(arr);
        
         for(int i = 0; i < list.size(); i++)
             list.set(i, arr[i]);
        return list;
    }
}