class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        List<Integer> indexes = new ArrayList();

        for (int i = 0; i < times.length; i++)
            indexes.add(i);

        Collections.sort(indexes, (a, b) -> times[a][0] - times[b][0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; i++)
            availableChairs.add(i); 

        for (int idx : indexes) {
            int arrival = times[idx][0];
            int leave = times[idx][1];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                int[] curr = occupiedChairs.poll();
                int l = curr[1]; // leave
                availableChairs.add(l);
            }

            int chair = availableChairs.poll();
            occupiedChairs.add(new int[]{leave, chair});

            if (idx == targetFriend)
                return chair;
        }

        return -1;
    }
}