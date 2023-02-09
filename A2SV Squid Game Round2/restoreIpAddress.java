import java.util.ArrayList;
import java.util.List;

class restoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> address = new ArrayList<>();

        backtrack(s, 0, address, res);

        return res;
    }

    void backtrack(String s, int i,List<String> address, List<String> res){
        if(address.size() == 4){
            if(i == s.length())
                res.add(String.join(".", address));
            return;
        }
        else{
            for(int j = i+1; j <= Math.min(i+3, s.length()); j++){
                String nextInt = s.substring(i, j);
                if(Integer.parseInt(nextInt) <= 255 && 
                (nextInt.equals("0") || !nextInt.startsWith("0"))){
                    address.add(nextInt);
                    backtrack(s, j, address, res);
                    address.remove(address.size()-1);
                }
            }
        }
    }
}