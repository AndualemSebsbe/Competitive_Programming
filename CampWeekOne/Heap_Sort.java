import java.util.*;
public class Heap_Sort {
    void printArray(int arr[],int n) {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[]) {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0) {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
        sc.close();
    }
    
}
    
class Solution {
        //Function to build a Heap from array.
        void buildHeap(int arr[], int n)
        {
            // Your code here
            for(int i = n/2 - 1; i >= 0; i--)
            heapify(arr, n, i);        // create a Max Heap
        }
     
        //Heapify function to maintain heap property.
        void heapify(int arr[], int n, int i)
        {
            // Your code here
            int largest = i; // Initialize largest as a root
            
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            
             // if left is larger than root
            if(l < n && arr[l] > arr[largest])
             largest = l;
             // if right is larger than root
            if(r < n && arr[r] > arr[largest])
             largest = r;
             // if largest is not root
             if(largest != i)
             {
                 int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                //  
                // arr = swap(arr, i, largest);
                 // recursively heapify the affected sub-tree
                 heapify(arr, n, largest);
             }
        }
        
        //Function to sort an array using Heap Sort.
        public void heapSort(int arr[], int n)
        {
            //code here
            
            //Buid Heap
            buildHeap(arr, n);
            
            //one by one Extract an element from heap
            for(int i = n-1; i >= 0; i--)
            {
               // Move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;    // swap the root and last node
                heapify(arr, i, 0);       // create a max Heap on reduced array
            }
            
        }
        
     }
     
     
    