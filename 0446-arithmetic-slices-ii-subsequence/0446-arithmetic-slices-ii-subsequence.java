class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int ans = 0;
		
		HashMap<Integer, Integer>[] map = new HashMap[arr.length];
		for(int i = 0; i < arr.length; i++) {
			map[i] = new HashMap<>();
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				long diff = (long)arr[i] - (long)arr[j];
				if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE)
					continue;
				
				int a = map[j].getOrDefault((int)diff, 0);
				int b = map[i].getOrDefault((int)diff, 0);
				
				ans += a;
				map[i].put((int)diff, a + b + 1);
			}
		}
		return ans;
    }
}