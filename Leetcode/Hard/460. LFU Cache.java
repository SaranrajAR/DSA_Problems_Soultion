class Node{
    int key,value,freq;
    Node next;
    Node prev;

    Node(int key,int value){
        this.key=key;
        this.value=value;
        this.freq=1;
    }
}
class DLL{
    Node head,tail;
    DLL(){
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public void insertFront(Node node){
        Node temp=head.next;
        head.next=node;
        node.next=temp;
        node.prev=head;
        temp.prev=node;
    }

    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public Node removeTail(){
        if(tail.prev==head) return null;
        Node last=tail.prev;
        deleteNode(last);
        return last;
    }

    public boolean isEmpty(){
        return head.next==tail;
    }
}
class LFUCache {

    public int capacity;
    public int minFreq;
    public HashMap<Integer,Node> keyMap;
    public HashMap<Integer,DLL> freqMap;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        minFreq=1;
        keyMap=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        Node node=keyMap.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;

        if(keyMap.containsKey(key)){
            Node node=keyMap.get(key);
            node.value=value;
            update(node);
        }
        else{
            if(keyMap.size()==capacity){
                DLL minList=freqMap.get(minFreq);
                Node toRemovefromMap=minList.removeTail();
                keyMap.remove(toRemovefromMap.key);
            }

            Node newNode=new Node(key,value);
            keyMap.put(key,newNode);

            DLL list=freqMap.get(1);
            if(list==null){
                list=new DLL();
                freqMap.put(1,list);
            }
            list.insertFront(newNode);
            minFreq=1;
        }
    }

    public void update(Node node){
        int freq=node.freq;
        DLL oldlist=freqMap.get(freq);
        oldlist.deleteNode(node);

        if(freq==minFreq && oldlist.isEmpty()) minFreq++;

        node.freq++;
        DLL newlist=freqMap.get(node.freq);
        if(newlist==null){
            newlist=new DLL();
            freqMap.put(node.freq,newlist);
        }

        newlist.insertFront(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
