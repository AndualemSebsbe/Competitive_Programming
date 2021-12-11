import java.util.*;

public class Thearte_Square{
    public static void main(String[] args){
        long flag=0;
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        String[] x=temp.split(" ");
       
         long num1=Integer.parseInt(x[0]);
          long num2=Integer.parseInt(x[1]);
          long num3=Integer.parseInt(x[2]);
          if((num1>=1)&&(num2>=1)&&(num3>=1) && (num1<=1000000000)&&(num2<=1000000000)&&(num3<=1000000000)){
          if((num1%num3!=0) && (num2%num3==0)){
             flag=(num1/num3) * (num2/num3) +(num2/num3); 
          }
          else if((num2%num3!=0) && (num1%num3==0)){
              flag=(num1/num3) * (num2/num3) + (num1/num3);
          }
          else if((num1%num3!=0) && (num2%num3)!=0){
              flag=(num1/num3) * (num2/num3) + (num1/num3) + (num2/num3) +(1);
          }
          else if((num1%num3==0)&&(num2%num3==0)){
              flag=num1/num3 * num2/num3;
          }
          }
        System.out.println(flag);
    }
}