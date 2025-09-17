class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int min = 100000, max = 0;
        Map<Integer, String> map = new HashMap();
        for(int i = 0; i < n; i++){
            map.put(heights[i], names[i]);
            min = Math.min(min, heights[i]);
            max = Math.max(max, heights[i]);
        }

        int[] counting = new int[max + 1];
        for(int height : heights){
            counting[height] += 1;
        }

        String[] res = new String[n];
        int idx = 0;
        for(int i = max; i >= min; i--){
            if(counting[i] != 0){
                res[idx++] = map.get(i);
            }
        }

        return res;
    }
}