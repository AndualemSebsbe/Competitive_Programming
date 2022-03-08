class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length;
        for(int i = 0; i < len; i++){
            if(flowerbed[i] == 0){
                boolean prev = (i == 0) || (flowerbed[i - 1] == 0);
                 boolean next = (i == len - 1) || (flowerbed[i +1] == 0);
                if(prev && next){
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
       return count>=n; 
    }
}