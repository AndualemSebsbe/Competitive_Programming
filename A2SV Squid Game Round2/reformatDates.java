class reformatDates {
    public String reformatDate(String date) {
        String[] d = date.split(" ");
        String[] nums = {"01", "02", "03", "04", "05", "06",
         "07", "08", "09", "10", "11", "12"};
        String[] str = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        StringBuilder sb = new StringBuilder();
        int val  = Integer.valueOf(d[0].substring(0, d[0].length()-2));

        sb.append(d[2]);
        sb.append("-");
        for(int i = 0; i < 12; i++){
            if(str[i].equals(d[1])){
                sb.append(nums[i]);
                sb.append("-");
            }
        }

        if(val < 10)
            sb.append("0"+val);
        else
            sb.append(""+val);
        
        return sb.toString();
    }
}