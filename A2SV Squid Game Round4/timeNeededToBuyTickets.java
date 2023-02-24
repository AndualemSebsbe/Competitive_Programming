import java.util.HashMap;
import java.util.Map;

class timeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(tickets[i], map.getOrDefault(tickets[i], 0) + 1);
        }

        int res = 0;
        for(int key : map.keySet()){
            if(tickets[k] >= key)
            res += (key*map.get(key));
            else
            res += (tickets[k] * map.get(key));
        }

        for(int i = k+1; i < n; i++){
            if(tickets[i] >= tickets[k])
            res -= 1;
        }
        return res;
    }
}