class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        int[] counting = new int[101];

        for(int seat : seats)
            counting[seat] += 1;
        
        // sort seats array using counting sort
        int idx = 0, m = counting.length;
        for(int i = 0; i < m; i++){
            while(counting[i] > 0){
                seats[idx++] = i;
                counting[i] -= 1;
            }
        }

        for(int student : students)
            counting[student] += 1;
        
        // sort students array using counting sort
        idx = 0;
        for(int i = 0; i < m; i++){
            while(counting[i]-- > 0)
                students[idx++] = i;
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            count += Math.abs(students[i] - seats[i]);
        }

        return count;
    }
}