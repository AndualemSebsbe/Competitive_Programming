import java.util.ArrayList;
import java.util.List;

public class pancake_Sort {
    
        public List<Integer> pancakeSort(int[] arr) {
            int len=arr.length;
            
            int k=1;
          List<Integer> aList1 = new ArrayList<Integer>();
            
           
            int sLen = len;
        for(int i=0; i<len; i++){
            if(!Sorted(arr)){
            int maxIdx=0;
            
            for(int j=0; j<sLen; j++){
                if(arr[maxIdx]<arr[j]){                
                    maxIdx=j;
                }           
            }
           
            k = maxIdx+1;
            aList1.add(k);
            int[] revArr =  revSubArray(arr, k);
            int[] reversedArr = new int[len];                  
            reversedArr = revArray(revArr,sLen );
            aList1.add(sLen);
                sLen--; //decrement the index to get index of the next greater element 
           
        }
        else
        {
          return aList1;
        }
        }    
            
        return aList1;
        }
        
        public int[] revSubArray(int[] arr,int k ){
           
             for (int i = 0; i < k / 2; i++)
            {
                int tempswap = arr[i];
                    arr[i] = arr[k - i - 1];
                    arr[k - i - 1] = tempswap;            
            }
            // for(int i=0, j=0; i<arr.length; i--){
            //     System.out.print(arr[0]);   
            // }
          // System.out.println(arr.length);
           return arr; 
        }
        
        public int[] revArray(int[] revArr, int sLen){
             
            for (int i = 0; i < sLen / 2; i++)
            {
                int tempswap = revArr[i];
                    revArr[i] = revArr[sLen - i - 1];
                    revArr[sLen - i - 1] = tempswap;            
            }
            
            return revArr;
        }
       
        public boolean Sorted(int a[]) {
           int n=a.length;
        for (int i = 0; i < n-1; i++) {
          if (a[i] > a[i+1]) {
          return false;
        }
       }
       return true;
       }
    }
