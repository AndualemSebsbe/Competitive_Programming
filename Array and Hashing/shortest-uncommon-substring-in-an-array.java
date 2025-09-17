class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<String, Integer> map = new HashMap();
        for(String str : arr){
            Set<String> set = new HashSet();
            for(int i = 0; i < str.length(); i++){
                String s = "";
                for(int j = i; j < str.length(); j++){
                    s += str.charAt(j);
                    if(!set.contains(s))
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    set.add(s);
                }
            }
            
            set = new HashSet();
        }
        
        int n = arr.length;
        String[] res = new String[n];
        for(int k = 0; k < n; k++){
            int len = arr[k].length();
            for(int i = 0; i < len; i++){
                String s = "";
                for(int j = i; j < len; j++){
                    s += arr[k].charAt(j);
                    
                    if(map.get(s) == 1){
                        if(res[k] == null)
                            res[k] = s;
                        else{
                            if(s.length() < res[k].length())
                                res[k] = s;
                            else if(s.length() == res[k].length()){
                                int val = s.compareTo(res[k]);
                                if(val < 0)
                                    res[k] = s;
                            } 
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(res[i] == null)
                res[i] = "";
        }
        return res;
    }
}