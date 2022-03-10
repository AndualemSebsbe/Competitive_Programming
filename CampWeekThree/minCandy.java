import java.util.Arrays;

class minCandy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        for(int i = 0; i < len - 1; i++){
            if(ratings[i + 1] > ratings[i]){
                candy[i + 1] = candy[i] + 1;
            }
        }
        for(int i = len - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i]){
                if(candy[i - 1] <= candy[i])
                candy[i - 1] = candy[i] + 1;
            }
        }
        int totalCandy = 0;
        for(int i = 0; i < len; i++)
            totalCandy += candy[i];
        return totalCandy;
    }
}