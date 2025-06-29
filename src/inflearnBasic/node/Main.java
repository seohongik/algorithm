package inflearnBasic.node;

class Node {

    Node head;
    int  data;
    Node next;

    Node(){
        this.head = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printListFromLast() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void printListFromFirst() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Node{" +
                "head=" + head +
                ", data=" + data +
                ", next=" + next +
                '}';
    }
}


class Main{

    public static void main(String[] args){


        Node node = new Node();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        System.out.println("node = " + node);
        node.printListFromLast();

        Node tail = new Node();
        tail.addLast(1);
        tail.addLast(2);
        tail.addLast(3);
        tail.addLast(4);
        System.out.println("tail = " + tail);
        tail.printListFromFirst();

    }
}