class kthSymbol {
    public int kthGrammar(int n, int k) {
        if(n==1)
            return 0;
        int p = kthGrammar((n-1), (k/2 + k%2));
        
           if(p == 0){
             if(k%2==0)
                return 1; 
             else
                 return 0;  
           }
        else if(p == 1){
            if(k%2==0)
                return 0;
            else
                return 1;
        }
        return p;
    }
}