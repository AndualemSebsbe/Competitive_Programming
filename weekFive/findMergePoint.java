    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    import java.io.*;
    
    public class findMergePoint {
    
        static class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;
    
            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }
    
        static class SinglyLinkedList {
            public SinglyLinkedListNode head;
            public SinglyLinkedListNode tail;
    
            public SinglyLinkedList() {
                this.head = null;
                this.tail = null;
            }
    
            public void insertNode(int nodeData) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
    
                if (this.head == null) {
                    this.head = node;
                } else {
                    this.tail.next = node;
                }
    
                this.tail = node;
            }
        }
    
        public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));
    
                node = node.next;
    
                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head1_curr = head1;
        SinglyLinkedListNode head2_curr = head2;
        
          while(head1_curr != head2_curr){
              if(head1_curr == null)
                  head1_curr = head2;
              else
                head1_curr = head1_curr.next;
              
              if(head2_curr == null)
                  head2_curr = head1;
              else
                head2_curr = head2_curr.next;
          }
        
         return head1_curr.data;    
      }
    }