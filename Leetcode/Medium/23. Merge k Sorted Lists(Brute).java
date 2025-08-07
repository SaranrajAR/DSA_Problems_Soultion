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
    public ListNode merge2Lists(ListNode first,ListNode second){
        ListNode newHead=new ListNode(-1);
        ListNode dummy=newHead;
        while(first!=null && second!=null){
            if(first.val<second.val){
                dummy.next=first;
                dummy=dummy.next;
                first=first.next;
            }
            else{
                dummy.next=second;
                dummy=dummy.next;
                second=second.next;
            }
        }
        if(first!=null) dummy.next=first;
        if(second!=null) dummy.next=second;
        return newHead.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead=new ListNode(Integer.MIN_VALUE);
        
        for(int i=0;i<lists.length;i++){

            newHead=merge2Lists(newHead,lists[i]);
        }
        return newHead.next;
        
    }
}
