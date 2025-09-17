package CampContest;

import java.util.*;

public class newYearAndHurry{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] str = s.split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int num = k;
        int count=0, i=1; 
        while((count < n)&&(num <= 240)){
            
        if(((num += (5*i)) > 240)) break;
            i++; count++;
        }
        System.out.println(count);
        input.close();
    }
}