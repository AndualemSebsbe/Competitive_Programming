import java.util.ArrayList;
import java.util.List;

class plateBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] pSum = new int[s.length()];
        List<Integer> list = new ArrayList();
        
        int plates = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*')
                plates++;
            pSum[i] = plates;
            if(s.charAt(i) == '|')
                list.add(i);
        }
        
        int i = 0;
        for(int[] query : queries){
            int start = bsearch1(query[0], list);
            if(start == -1){
                ans[i++] = 0;
                continue;
            }
            
            int end = bsearch2(query[1], list);
            if(start > end || end == -1){
                ans[i++] = 0;
            }else{
                ans[i++] = pSum[end] - pSum[start];
            }
            
        }
        
        return ans;
    }
    
    public int bsearch1(int indx, List<Integer> list){
        int l = 0, r = list.size() - 1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid) < indx){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        
        if(l == list.size())
            return -1;
        return list.get(l);
    }
    
    public int bsearch2(int indx, List<Integer> list){
        int l = 0, r = list.size() - 1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid) > indx){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        if(r == -1)
            return -1;
        return list.get(r);
    }
}