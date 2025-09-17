/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] row : res)
            Arrays.fill(row, -1);

        int top = 0, right = n - 1, bottom = m - 1, left = 0;
        int dir = 0;

        while (head != null) {
            if (dir == 0) {
                for (int col = left; col <= right; col++) {
                    if (head == null)
                        return res;

                    res[top][col] = head.val;
                    head = head.next;
                }

                top += 1;
            }
            else if (dir == 1) {
                for (int row = top; row <= bottom; row++) {
                    if (head == null)
                        return res;

                    res[row][right] = head.val;
                    head = head.next;
                }

                right -= 1;
            }
            else if (dir == 2) {
                for (int col = right; col >= left; col--) {
                    if (head == null)
                        return res;

                    res[bottom][col] = head.val;
                    head = head.next;
                }

                bottom -= 1;
            }
            else if (dir == 3) {
                for (int row = bottom; row >= top; row--) {
                    if (head == null)
                        return res;

                    res[row][left] = head.val;
                    head = head.next;
                }

                left += 1;
            }

            dir = (dir + 1) % 4;
        }

        return res;
    }
}