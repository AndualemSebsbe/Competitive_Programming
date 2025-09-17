//recursion using Josephus
class winnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        if(n == 1) return 1;
        
        int x = findTheWinner(n-1, k);
        int y = (x+k)%n == 0 ? n : (x+k)%n;
        
        return y;
    }
}