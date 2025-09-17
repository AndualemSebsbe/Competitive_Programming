class Solution {

    static int[] moveZerosToEnd(int[] arr) {
        // your code goes here
        int l = 0, n = arr.length;
        for(int r = 0; r < n; r++){
        if(arr[r] != 0){
            swap(arr, l, r);
            l += 1;
        }
        }
        
        return arr;
    }
  
  static void swap(int[] arr, int l, int r){
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }

	public static void main(String[] args) {
	
	}
}

//arr = [1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0]
