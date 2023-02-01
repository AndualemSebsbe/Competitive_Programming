import java.util.Arrays;

class earliestPossibleDayofBallon {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] seed = new int[n][2];

        for(int i = 0; i < n; i++){
            seed[i][0] = plantTime[i];
            seed[i][1] = growTime[i];
        }

        Arrays.sort(seed, (a, b) -> b[1] - a[1]);

        int time = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            time += seed[i][0];
            max = Math.max(max, time + seed[i][1]);
        }

        return max;
    }
}