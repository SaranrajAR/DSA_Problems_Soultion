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
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode prev=null;
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
    public ListNode findkthnode(ListNode head,int k){
        k--;
        while(head!=null && k>0){
            k--;
            head=head.next;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode kthnode=findkthnode(temp,k);
            if(kthnode==null){
                if(prev!=null){
                    prev.next=temp;
                }
                break;

            }
            ListNode front=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthnode;
            }
            else{
                prev.next=kthnode;

            }
            prev=temp;
            temp=front;
        }
        return head;

        
        
    }
}
