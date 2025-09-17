class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if((n % groupSize) != 0)
            return false;

        Map<Integer, Integer> freqMap = new TreeMap();
        for(int key : hand)
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
            
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(freq == 0)
                continue;

            while(freq-- > 0){
                for(int i = key; i < key + groupSize; i++){
                    if(freqMap.getOrDefault(i, 0) == 0)
                        return false;
                    
                    freqMap.put(i, freqMap.get(i) - 1);
                }
            }
        }

        return true;
    }
}