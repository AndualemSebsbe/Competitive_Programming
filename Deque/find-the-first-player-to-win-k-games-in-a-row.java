class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int maxIdx = 0, n = skills.length;
        for(int i = 0; i < n; i++){
            if(skills[i] > skills[maxIdx])
                maxIdx = i;
        }

        
        if(k >= n)
            return maxIdx;
        
        Deque<Integer> deque = new ArrayDeque();
        for(int i = 0; i < n; i++){
            deque.add(skills[i]);
        }
        
        Map<Integer, Integer> map = new HashMap();
        int maxSkill = Integer.MIN_VALUE;
        while(k != 0){
            int num1 = deque.removeFirst();
            int num2 = deque.removeFirst();
            if(num1 > num2){
                deque.addFirst(num1);
                deque.addLast(num2);       
            }
            else{
                deque.addFirst(num2);
                deque.addLast(num1);
            }
            
            int num = deque.getFirst();
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) == k){
                maxSkill = num;
                break;
            }
        }

        for(int i = 0; i < n; i++){
            if(skills[i] == maxSkill)
                return i;
        }
        
        return -1;
    }
}