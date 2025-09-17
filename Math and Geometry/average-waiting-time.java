class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int finish = customers[0][0] + customers[0][1];
        double waiting = customers[0][1];
        for(int i = 1; i < n; i++){
            int arrival = customers[i][0], time = customers[i][1];
            if(finish > arrival)
                waiting += (finish - arrival);
            else
                finish = arrival;

            waiting += time;
            finish += time;
        }

        double avgWaiting = waiting / n;
        return avgWaiting;
    }
}