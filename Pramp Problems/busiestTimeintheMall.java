
class busiestTimeintheMall {
	
  static int findBusiestPeriod(int[][] data) {
    // your code goes here
    int maxTimestamp = 0, n = data.length;
    int counter = 0, maxCounter = 0;
    if(n == 1)
        return data[0][0];
    
    for(int i = 0; i < n; i++){
      
      if(data[i][2] == 1)
        counter += data[i][1];
      else
        counter -= data[i][1];
      
      if(i < n-1 && data[i][0] == data[i+1][0])
          continue;
      
      if(counter > maxCounter){
        maxCounter = counter;
        maxTimestamp = data[i][0];
      }
    }
    
    return maxTimestamp;
  }

  public static void main(String[] args) {

  }

}