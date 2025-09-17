public class selectionSort {
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        return arr[i];
	}
	
	void selectionSorts(int arr[], int n) {
	    //code here
	    if(n >= 1 && n <= 1000){
	        for(int i = 0; i < n; i++){
	            int min = i;
	            for(int j = i + 1; j < n; j++){
	                if(arr[min] > arr[j]){
	                    int temp=arr[min];
	                    arr[min]=arr[j];
	                    arr[j]=temp;
	                }
	                select(arr, i);
	            }
	        }
	    }
	}
}