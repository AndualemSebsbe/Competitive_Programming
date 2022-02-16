

import java.util.Scanner;

public class lovelyPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder number = new StringBuilder(sc.next()); //because it's mutable and strings are immutable
        System.out.println(number.toString()+""+number.reverse());
    }
}