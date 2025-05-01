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
    private int Gcd(int a ,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=head;
        ListNode front=head.next;
        while(front!=null){
            int a=prev.val;
            int b=front.val;
            int gcdval=0;
            gcdval=Gcd(b,a);
            ListNode temp=new ListNode(gcdval);
            prev.next=temp;
            temp.next=front;
            prev=front;
            front=front.next;
        }
        return head;
        
    }
}
