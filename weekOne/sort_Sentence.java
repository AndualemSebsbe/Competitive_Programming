class sort_Sentence {
    public String sortSentence(String s) {
        int count=1;
        String[] str=s.split(" ");
         for (int i = 0; i < s.length() - 1; i++)
        {
            if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' '))
            {
                count++;
            }
        }
         String newS=new String();
         char j='1';
        for(int i=0; i<count; i++){
            int n=str[i].length();
            if((str[i].charAt(n-1))==(j)){
                 StringBuilder build =new StringBuilder(str[i]); 
                 build.deleteCharAt(n-1);
                newS+=(" "+build);
               // k+=(str[i].length()+1);
                i=-1;
                j++;
        
        }
        }
       char[] ch=newS.toCharArray();
        String s1="";
        for(int i=1; i< ch.length;i++){
            s1+=ch[i];
        }
       
        return s1;
        }    
}