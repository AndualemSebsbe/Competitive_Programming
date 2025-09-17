class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStuds = singleClass[1];
            double gain = calculateGain(passes, totalStuds);
            maxHeap.offer(new double[] { gain, passes, totalStuds });
        }

        while (extraStudents-- > 0) {
            double[] cur = maxHeap.poll();
            double curGain = cur[0];
            int passes = (int) cur[1];
            int totalStuds = (int) cur[2];
            
            maxHeap.offer(
                    new double[] {
                            calculateGain(passes + 1, totalStuds + 1),
                            passes + 1,
                            totalStuds + 1,
                    });
        }

        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] cur = maxHeap.poll();
            int passes = (int) cur[1];
            int totalStuds = (int) cur[2];
            totalPassRatio += (double) passes / totalStuds;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStuds) {
        return ((double) (passes + 1) / (totalStuds + 1) -
                (double) passes / totalStuds);
    }
}