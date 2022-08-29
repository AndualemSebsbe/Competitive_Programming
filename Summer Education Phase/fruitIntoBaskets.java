import java.util.HashSet;
import java.util.Set;

public class fruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int max = 1, l = 0, r = 1, len = fruits.length;
        
        while(r < len){
            Set<Integer> set = new HashSet();
                set.add(fruits[r-1]);
                set.add(fruits[r]);
                while(r < len && set.contains(fruits[r])){
                        r++;
                }

                max = Math.max(max, r-l); 
                int i = 1, temp = r;
                while(temp > 1 && fruits[temp-1] == fruits[temp-2])
                {
                    temp--; i++;
                }
                    
            l = r-i;
        }
        
        
        return max;
    }
}