class Solution {

    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> numsArray = new ArrayList<>();
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++)
                numsArray.add(grid[row][col]);
        }

        Collections.sort(numsArray);

        int len = numsArray.size();
        int finalCommonNum = numsArray.get(len / 2);

        for (int num : numsArray) {
            if (num % x != finalCommonNum % x)
                return -1;

            res += Math.abs(finalCommonNum - num) / x;
        }

        return res;
    }
}