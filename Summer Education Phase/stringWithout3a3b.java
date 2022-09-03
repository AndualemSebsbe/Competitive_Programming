class stringWithout3a3b {
    public String strWithout3a3b(int a, int b) {
        String str = "";
        
        while(a > 0 || b > 0){
           
            if(a > b){
            if(str.length() >= 2){
                String subString = str.substring(str.length()-2);
                if(!subString.equals("aa")){
                    str += "a";
                    a--;
                }else{
                    str += "b";
                    b--;
                }
            }else{
                str += "a";
                a--;
            }
        }else{
            if(str.length() >= 2){
                String subString = str.substring(str.length()-2);
                System.out.println(subString);
                if(!subString.equals("bb")){
                    str += "b";
                    b--;
                }else{
                    str += "a";
                    a--;
                }
            }else{
                str += "b";
                b--;
            }
        }
        }
        
       return str; 
    }
}