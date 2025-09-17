class sentenceReverse {

  static char[] reverseWords(char[] arr) {
    // your code goes here
    int l = 0, r = 0;
    //StringBuilder sbL = new StringBuilder();
    if(arr.length == 1)
      return arr;
    
    reverse(arr, l, arr.length-1);
    
    while(r < arr.length){
      if(arr[r] == ' '){
        reverse(arr, l, r-1);
        l = r+1;
      }
      
      if (arr.length-1 == r) {
        reverse(arr, l, r );
      }
      
      r += 1;
    }
    
    return arr;
    
  }
  
  static void reverse(char[] arr, int l, int r){
    while(l < r){
      char temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;
      l += 1;
      r -= 1;
    }
  }

  public static void main(String[] args) {

  }

}  
