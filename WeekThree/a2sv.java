// package leetcode;

// import java.util.ArrayList;
// import java.util.List;

// // https://leetcode.com/problems/fizz-buzz/submissions/

// class Solution {
//     public List<String> fizzBuzz(int n) {
//         List<String> answer = new ArrayList<String>();

//         for (int i = 1; i <= n; i++) {
//             // checking if the number is divisible by 3 and 5 with out a remender
//             if (i % 3 == 0 && i % 5 == 0) {
//                 answer.add("FizzBuzz");
//             }
//             // checking if the number is divisible by 3 with out a remender
//             else if (i % 3 == 0) {
//                 answer.add("Fizz");
//             }
//             // checking if the number is divisible by 5 with out a remender
//             else if (i % 5 == 0) {
//                 answer.add("Buzz");
//             } else {
//                 answer.add(Integer.toString(i));
//             }
//         }

//         return answer;
//     }
// }