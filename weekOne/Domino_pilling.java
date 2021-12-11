import java.util.*;

public class Domino_pilling{
    public static void main(String[] args){
     
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        String[] x=temp.split(" ");
        
         int num1=Integer.parseInt(x[0]);
          int num2=Integer.parseInt(x[1]);
        System.out.println(((num1*num2)/2));
    }
}