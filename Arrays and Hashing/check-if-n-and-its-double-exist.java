class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Double> set = new HashSet();
        Arrays.sort(arr);
        for (int num : arr) {
            if (set.contains((double) num))
                return true;
            
            if (num >= 0)
                set.add(num * 2.0);
            else
                set.add(num / 2.0);
        }

        return false;
    }
}