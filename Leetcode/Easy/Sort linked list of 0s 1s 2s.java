/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution
{
    public static Node sortList(Node head) {
        // Write your code here
        Node zerohead=new Node(-1);
        Node onehead=new Node(-1);
        Node twohead=new Node(-1);
        Node zero=zerohead;
        Node one=onehead;
        Node two=twohead;
        Node temp= head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else {
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=(onehead.next!=null) ? onehead.next:twohead.next;
        one.next=twohead.next;
        two.next=null;
        return zerohead.next;        

        
    }
}
