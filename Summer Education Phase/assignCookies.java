import java.util.Arrays;

public class assignCookies {

    public int findContentChildren(int[] g, int[] s) {
        
        int i = 0, j = 0, count = 0;
        System.out.println(g.length);
        System.out.println(s.length);
        Arrays.sort(s);
        Arrays.sort(g);
        
        for(; i< g.length; i++){
            while(j < s.length){
                if(s[j] >= g[i]){
                    j++; count++;
                    break;
                }
                j++;
            }
            
        }
        
        return count;
    }
}