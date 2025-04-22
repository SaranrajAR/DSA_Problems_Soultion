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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
       
        if(head==null) return null;
        ListNode front=temp.next;
        while(front!=null){
            temp.next=prev;
            prev=temp;
            temp=front;
            front=front.next;
        }
        temp.next=prev;
        prev=temp;
        return prev;

        
    }
}
