class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length-1, count = 0;
        Arrays.sort(people);

        while(l <= r){
            int sum = people[l] + people[r];
            if(sum <= limit){
                l += 1; r -= 1;
            }
            else
                r -= 1;
            count += 1;
        }

        return count;
    }
}