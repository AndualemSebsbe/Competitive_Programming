class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0], dst = edges[i][1];
            double pathProb = succProb[i];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(new Pair(dst, pathProb));

            if(!graph.containsKey(dst))
                graph.put(dst, new ArrayList());
            graph.get(dst).add(new Pair(src, pathProb));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.add(new Pair(1.0, start));
        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double curProb = cur.getKey();
            int curNode = cur.getValue();
            if (curNode == end)
                return curProb;

            for (Pair<Integer, Double> next : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nextNode = next.getKey();
                double pathProb = next.getValue();
                if (curProb * pathProb > maxProb[nextNode]) {
                    maxProb[nextNode] = curProb * pathProb;
                    pq.add(new Pair(maxProb[nextNode], nextNode));
                }
            }
        }

        return 0d;
    }
}