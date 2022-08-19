public class kokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles = 0;
        for(int pile : piles) {
            if(pile > maxPiles){
                maxPiles = pile;
            }
        }
        int l = 1, r = maxPiles;
        while(l < r){
            int mid = l + (r-l)/2;
            
            if(canEat(piles, mid, h)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
    
    public boolean canEat(int[] piles, int speed, int h){
        double hourSpent = 0;
        for(int pile : piles){
            hourSpent += Math.ceil((double)pile/speed);
        }
        
        return (int)hourSpent <= h;
    }
}