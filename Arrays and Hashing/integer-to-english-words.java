class Solution {
    int[] nums = {1000000000, 1000000, 1000,100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    String[] s = {"Billion", "Million", "Thousand",    "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
    Map<Integer, String> numToWord;
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";

        numToWord = new HashMap();
        for(int i = 0; i < s.length; i++)
            numToWord.put(nums[i], s[i]);

        String res = "";
        while(num > 0) {
            if(num >= 1_000_000_000) {
                int quo = num / 1_000_000_000;
                res += numToWord.get(quo) + " ";
                res += numToWord.get(1_000_000_000) + " ";

                num -= (quo * 1_000_000_000);
            }
            else if(num >= 1_000_000) {
                int quo = num / 1_000_000;
                res += intToEnglish(quo) + " ";
                res += numToWord.get(1_000_000) + " ";

                num -= (quo * 1_000_000);
            }
            else if(num >= 1_000) {
                int quo = num / 1_000;
                res += intToEnglish(quo) + " ";
                res += numToWord.get(1_000) + " ";

                num -= (quo * 1_000);
            }
            else {
                res += intToEnglish(num);
                num = 0;
            }
        }

        int n = res.length();
        if(res.charAt(n - 1) == ' ')
            return res.substring(0, n - 1);

        return res;
    }

    String intToEnglish(int num) {
        String word = "";
        while (num > 0) {
            if (num >= 100) {
                int quo = num / 100;
                word += numToWord.get(quo) + " ";
                word += numToWord.get(100) + " ";

                num -= (quo * 100);
            }
            else if (num > 20) {
                int quo = num / 10;
                word += numToWord.get(quo * 10) + " ";

                num -= (quo * 10);
            }
            else {
                word += numToWord.get(num);
                num = 0;
            }
        }

        int n = word.length();
        if(word.charAt(n - 1) == ' ')
            return word.substring(0, n - 1);

        return word;
    }
}