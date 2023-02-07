class crawlerLogFolder {
    public int minOperations(String[] logs) {
        int count = 0;
        for(String log : logs){
            if(log.equals("../")){
                if(count != 0)
                    count -= 1;
            }
            else if(log.equals("./")){
                continue;
            }
            else
                count += 1;
        }

        return count;
    }
}