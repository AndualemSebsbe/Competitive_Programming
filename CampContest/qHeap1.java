import java.io.*;
import java.util.*;

public class qHeap1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int q = scn.nextInt();
        while(q-->0){
            int q1 = scn.nextInt();
            if(q1==1){
                int num = scn.nextInt();
                heap.add(num);
            }else if(q1==2){
                int num = scn.nextInt();
                heap.remove(num);
            }else if(q1==3){
                System.out.println(heap.peek());
            }
        }
    }
}