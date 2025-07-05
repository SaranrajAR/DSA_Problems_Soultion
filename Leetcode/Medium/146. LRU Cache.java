class Node {
    int k;
    int data;
    Node prev;
    Node next;

    Node(int key,int data) {
        this.k = key;
        this.data=data;
    }
}

class LRUCache {
    public HashMap<Integer,Node> map;
    public Node head;
    public Node tail;
    public int capacity;

    public  void delete(Node temp){
        Node front=temp.next;
        Node back=temp.prev;
        back.next=front;
        front.prev=back;
    }

    public  void insertFront(Node temp){
        Node t=head.next;
        temp.prev=head;
        temp.next=t;
        t.prev=temp;
        head.next=temp;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node temp=map.get(key);
        delete(temp);
        insertFront(temp);
        return temp.data;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.data = value;
            delete(temp);
            insertFront(temp);
        } else {
            if (map.size() == capacity) {
                Node temp = tail.prev;
                map.remove(temp.k);
                delete(temp);
            }
            Node temp=new Node(key,value);
            insertFront(temp);
            map.put(key,temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
