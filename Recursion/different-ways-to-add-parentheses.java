public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                
                for (int p1 : part1Ret) {
                    for (int p2 : part2Ret) {
                        int c = 0;
                        char ch = input.charAt(i);
                        if (ch == '+')
                            c = p1 + p2;
                        else if (ch == '-')
                            c = p1 - p2;
                        else if (ch == '*')
                            c = p1 * p2;

                        ret.add(c);
                    }
                }
            }
        }

        if (ret.size() == 0)
            ret.add(Integer.valueOf(input));
        
        return ret;
    }
}