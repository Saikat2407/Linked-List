package saikat;

public class LL {
    public Node head;
    public Node tail;
    public int size;

    public LL() {
        this.size = 0;
    }


    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){
        if (index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }
    // delete the first element form the linked-list
    public int DeletefirstElement(){
        int Head = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return Head;
    }

    public int DeletelastElement(){
        if(size <= 1){
            DeletefirstElement();
        }
        Node secondlast = get(size-2);
        int Tail = tail.value;
        tail = secondlast;
        tail.next = null;
        size--;

        return Tail;
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int delete(int index) {
        if (index == 0) {
            return DeletefirstElement();
        }
        if (index == size - 1) {
            return DeletelastElement();
        }

        Node prev = get(index-1);
        int prevVal = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return prevVal;
    }


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END OF LIST");
    }
}

