import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 

public class poisoned_dagger{

    static class FastReader {
        BufferedReader bReader;
        StringTokenizer st;
 
        public FastReader()
        {
            bReader = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bReader.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = bReader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

   public static boolean check(long k,int arr[],long req){
       long count=k;
       for(int i=0;i<arr.length-1;i++){
          count+=(Math.min(k,arr[i+1]-arr[i]));
       }

          if(count>=req) return true;
          return false;

   } 



public static void main(String[] args){
    FastReader sc = new FastReader();
     int t=sc.nextInt();
     while(t-->0){
         int n=sc.nextInt();
         long k=sc.nextLong();
         int arr[]=new int[n];
         for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
         }

         long low=0,high=k;
         long ans=k;
        
         while(low<=high){
             long mid=(low+high)/2;
             if(check(mid,arr,k)==true){
                 ans=Math.min(ans,mid);
                 high=mid-1;
             }else{
                 low=mid+1;
             }
         }
         System.out.println(ans);
   
     }
}
}