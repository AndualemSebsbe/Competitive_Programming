class countValidPickupandDelivery {
    public int countOrders(int n) {
        long mod = (long) (Math.pow(10, 9) + 7);
        long res = 1;
        for(int i = 1; i <= n; i++){
            res *= i;
            res %= mod;
            res *= (2*i - 1);
            res %= mod;
        }
        return (int) res;
    }
}