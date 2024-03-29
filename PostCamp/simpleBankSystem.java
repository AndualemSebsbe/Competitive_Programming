package PostCamp;

class simpleBankSystem {
    int n;
    long[] arr;

    public simpleBankSystem(long[] balance) {
        n = balance.length;
        arr = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > n || account2 > n)
            return false;
        if(money > arr[account1-1])
            return false;

        arr[account1-1] -= money;
        arr[account2-1] += money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > n)
            return false;
        
        arr[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > n || money > arr[account-1])
            return false;
        
        arr[account-1] -= money;

        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */