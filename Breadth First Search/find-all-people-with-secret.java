class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Sort meetings in increasing order of time
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        Map<Integer, List<int[]>> sameTimeMeetings = new TreeMap();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], time = meeting[2];
            if(!sameTimeMeetings.containsKey(time))
                sameTimeMeetings.put(time, new ArrayList());
            sameTimeMeetings.get(time).add(new int[]{x, y});
        }
        
        // Boolean Array to mark if a person knows the secret or not
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        // Process in increasing order of time
        for (int time : sameTimeMeetings.keySet()) {
            Map<Integer, List<Integer>> meet = new HashMap<>();
            for (int[] meeting : sameTimeMeetings.get(time)) {
                int x = meeting[0], y = meeting[1];
                if(!meet.containsKey(x))
                    meet.put(x, new ArrayList());
                meet.get(x).add(y);

                if(!meet.containsKey(y))
                    meet.put(y, new ArrayList());
                meet.get(y).add(x);
            }

            Set<Integer> start = new HashSet<>();
            for (int[] meeting : sameTimeMeetings.get(time)) {
                int x = meeting[0], y = meeting[1];
                if (knowsSecret[x])
                    start.add(x);

                if (knowsSecret[y])
                    start.add(y);
            }
            
            Queue<Integer> q = new LinkedList<>(start);
            while (!q.isEmpty()) {
                int person = q.poll();
                if(meet.containsKey(person)){
                    for (int nextPerson : meet.get(person)) {
                        if (!knowsSecret[nextPerson]) {
                            knowsSecret[nextPerson] = true;
                            q.offer(nextPerson);
                        }
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (knowsSecret[i])
                ans.add(i);
        }

        return ans;
    }
}