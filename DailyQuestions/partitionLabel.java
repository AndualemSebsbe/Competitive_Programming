import java.util.ArrayList;
import java.util.List;

class partitionLabel {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        int[] lastIndexes = new int[26];
        for(int i = 0; i < s.length(); i++)
            lastIndexes[s.charAt(i) - 'a'] = i;
        
        int i = 0;
        while(i < s.length()){
            int end = lastIndexes[s.charAt(i) - 'a'];
            int partitionIndex = i;
            
            while(partitionIndex != end)
                end = Math.max(end, lastIndexes[s.charAt(partitionIndex++) - 'a']);
            list.add(partitionIndex - i + 1);
            i = partitionIndex + 1;
        }
        
        return list;
    }
}