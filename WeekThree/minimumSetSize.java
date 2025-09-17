import java.util.Arrays;
import java.util.HashMap;

class minimumSetSize {
    public int minSetSize(int[] arr) {
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxFreq = 0;
        int equalFreq = 1;
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
            
            maxFreq = Math.max(map.get(i), maxFreq);
            
           // sumOfFreq[j] = sumOfFreq[j-1] + maxFreq
        }
        int j = 0;      
        // store each frequency of the array
        int[] freq = new int[map.size()];
       for(HashMap.Entry<Integer, Integer> entry: map.entrySet()) {
            if(j<map.size())
            freq[j++] = entry.getValue();            
        }
       
        // sort frequency of the array
        Arrays.sort(freq);
         //if there is equal freq with the maxFreq 
         for(int i=map.size()-2; i>=0; i--){
             if(maxFreq==freq[i]){
                 equalFreq++;
             }
         }
        // length of original array
        int len = arr.length;
         int count=1*equalFreq;
        //if all of frequency have
        if(maxFreq==1){
            return len/2;
        }
         if(equalFreq*maxFreq >= len/2 )
        {            
            return equalFreq*1;
        }
        else{
        
        int  sumOfFreq = maxFreq*equalFreq;
            int maxLen = map.size()-1;
        for(int i= maxLen-equalFreq; i>=0; i--){
           sumOfFreq += freq[i];
            count++;
         if(sumOfFreq >= len/2){    
             int x=count;
             return x;
         }
            
        }
    }
        return 0;
    }
}