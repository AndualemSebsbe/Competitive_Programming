import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class topKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        PriorityQueue<String> pq = 
            new PriorityQueue<>(new Comparator<String>(){
                @Override
                public int compare(String word1, String word2){
                    int freq1 = map.get(word1);
                    int freq2 = map.get(word2);
                    if(freq1 == freq2) return               word2.compareTo(word1);
                    return freq1 - freq2;
                }
            });
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k) pq.poll();
        }
        
        List<String> kWords = new ArrayList<>();
         for(int i=0; i<k; i++)
            kWords.add(pq.poll());           
    
        Collections.reverse(kWords);
        return kWords;
    }
}