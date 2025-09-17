class Solution {
    public String countOfAtoms(String formula) {
        int i = 0, j = 0, k = 0, n = formula.length();
        Stack<Pair<String, Integer>> st = new Stack();
        for(i = 0; i < n; i++){
            String element = "", strDigits = "";
            char c = formula.charAt(i);
            if(Character.isUpperCase(c)){
                element += c;
                for(j = i + 1; j < n; j++){
                    c = formula.charAt(j);
                    if(!Character.isLowerCase(c))
                        break;
                    element += c;
                }

                for(k = j; k < n; k++){
                    c = formula.charAt(k);
                    if(!Character.isDigit(c))
                        break;
                    strDigits += c;
                }

                if(strDigits.equals(""))
                    strDigits = "1";
                
                int digits = Integer.valueOf(strDigits);
                st.add(new Pair(element, digits));

                i = k - 1;
            }
            else if(c == '(')
                st.add(new Pair("(", -1));
            else if(c == ')'){
                String strCount = "";
                for(j = i + 1; j < n; j++){
                    c = formula.charAt(j);
                    if(!Character.isDigit(c))
                        break;
                    strCount += c;
                }

                if(strCount.equals(""))
                    strCount = "1";
                int count = Integer.valueOf(strCount);

                Pair<String, Integer> opening = new Pair("(", -1);
                Stack<Pair<String, Integer>> tempSt = new Stack();
                while(!st.peek().equals(opening)){
                    Pair<String, Integer> cur = st.pop();
                    tempSt.add(new Pair(cur.getKey(), cur.getValue() * count));
                }
                st.pop();

                while(!tempSt.empty())
                    st.add(tempSt.pop());

                i = j - 1;
            }
        }

        Map<String, Integer> map = new TreeMap();
        while(!st.empty()){
            Pair<String, Integer> cur = st.pop();
            String str = cur.getKey();
            map.put(str, map.getOrDefault(str, 0) + cur.getValue());
        }  

        String res = "";
        for(String element : map.keySet()){
            int digits = map.get(element);
            res += element;
            if(digits > 1)
                res += digits;
        }      

        return res;
    }
}