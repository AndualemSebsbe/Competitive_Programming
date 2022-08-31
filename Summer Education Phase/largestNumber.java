import java.util.Comparator;

public abstract class largestNumber {

    class LargeNumComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b){
            return (b + a).compareTo(a + b);
        }
    }
    public String largestNumber(int[] nums) {
        String[] sArr = new  String[nums.length];
        int i = 0;
        for(int num : nums) sArr[i++] = String.valueOf(num);
        
        Arrays.sort(sArr, new LargeNumComparator());
        
        if(sArr[0].equals("0")) return "0";
        
        String largeNumStr = new String();
        for(String s : sArr)
            largeNumStr += s;
        return largeNumStr;
    }
}