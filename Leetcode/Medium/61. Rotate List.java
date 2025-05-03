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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        temp=head;
        if(k%length==0) return head;
        int requirenode=k%length;
        ListNode prev=null;
        for(int i=0;i<length-requirenode;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        ListNode newhead=temp;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        return newhead;

        
        
        
    }
}
