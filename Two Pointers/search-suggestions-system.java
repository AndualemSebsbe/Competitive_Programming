class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = searchWord.length(), proLen = products.length;
        Arrays.sort(products);
        int l = 0, r = proLen - 1;
        List<List<String>> res = new ArrayList();
        for(int i = 0; i < n; i++){
            char c = searchWord.charAt(i);

            while(l <= r && (products[l].length() <= i || 
                products[l].charAt(i) != c))
                l += 1;

            while(l <= r && (products[r].length() <= i || 
                products[r].charAt(i) != c))
                r -= 1;
            
            int remain = r - l + 1;
            int min = Math.min(3, remain);
            List<String> list = new ArrayList();
            for(int j = 0; j < min; j++)
                list.add(products[l + j]);
            res.add(list);
        }

        return res;
    }
}