public class boatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, count = 0;
        while(l < r){
            if((people[l] + people[r]) > limit){
                count++; r--;
            }
            else{
                count++;
                l++; r--;
            }
        }
        if(l == r) count++;
        return count;
    }
}