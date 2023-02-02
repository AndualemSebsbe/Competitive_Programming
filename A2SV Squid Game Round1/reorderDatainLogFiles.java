import java.util.Arrays;

class reorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
        String[] str1 = s1.split(" ", 2);
        String[] str2 = s2.split(" ", 2);

        boolean isLet1=Character.isLetter(str1[1].charAt(0));
        boolean isLet2=Character.isLetter(str2[1].charAt(0));

        if(isLet1 && isLet2){
            int comp = str1[1].compareTo(str2[1]);
            if(comp == 0)
                return str1[0].compareTo(str2[0]);
            return comp;
        }
        else if(!isLet1 && !isLet2)
            return 0;
        else if(isLet1 && !isLet2)
            return -1;
        else
            return 1;
        
        });

        return logs;
    }
}