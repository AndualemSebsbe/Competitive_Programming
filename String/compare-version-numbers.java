class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("[.]");
        String[] str2 = version2.split("[.]");

        int len = Math.max(str1.length, str2.length);
        int[] ver1 = new int[len];
        int idx1 = 0;
        for(String s : str1){
            int res = 0;
            for(int i = 0; i < s.length(); i++)
                res = res * 10 + (s.charAt(i) - '0');
            ver1[idx1++] = res;
        }
        
        int[] ver2 = new int[len];
        int idx2 = 0;
        for(String s : str2){
            int res = 0;
            for(int i = 0; i < s.length(); i++)
                res = res * 10 + (s.charAt(i) - '0');
            ver2[idx2++] = res;
        }

        for(int i = 0; i < len; i++){
            if(ver1[i] < ver2[i])
                return -1;
            else if(ver1[i] > ver2[i])
                return 1;
        }

        return 0;
    }
}