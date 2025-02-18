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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        int size = Size(head);
        ListNode head2 = head;
        if (size == 1) return null; // If only one node exists, return null
        else if (n == size) head = head.next; // If removing the first node, update head
        else{
            for(int i = 1 ; i < size - n; i++){
                head2 = head2.next;
            }
            head2.next = head2.next.next;
        }
        return head;
    }
    public int Size(ListNode list){
        ListNode head = list;
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
}