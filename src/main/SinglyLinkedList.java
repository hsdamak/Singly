package main;

public class SinglyLinkedList {

    private Node head = null;
    private int size = 0;

    // method to insert a new node at the head
private void insertHead(int value){
   this.head = new Node(value, this.head);
   /* Node node = new Node(value, head);
   head = node;*/
  size++;
}

//method to insert a new node after a node
private void insertAfter(int value, Node node ){
   node.next = new Node(value, node.next);
    size++;
}

public void insert(int value){
    if(head == null){
        insertHead(value);
    }else{
        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        insertAfter(value, temp);
    }
}

private  int removeHead(){
    int response = -1;
    Node temp = this.head;//copy of node
    if(head != null){
        this.head = this.head.next;
    }
    if(temp != null){
        size--;
        response = temp.data;
    }
    return response;
}

private int removeAfter(Node node){
    int response = -1;
    Node temp=node.next;

    if(temp != null){
        response = temp.data;
        node.next=temp.next;
        size--;
    }
return response;
}

public int remove(int data){
    int response = -1;
    Node temp = this.head;
    if(temp.data == data){
        removeHead();
    }else{
        while(temp.next != null){
            if(temp.next.data == data){
                                response=removeAfter(temp);
                break;
            }
        temp =temp.next;
        }
    }
    return response;
}

public boolean search(int data){
    boolean response = false;
    Node temp = this.head;
    while(temp!=null){
    if(temp.data == data){
        response = true;
        break;
    }
    temp = temp.next;
    }
    return response;
}



public String toString(){
    StringBuilder result = new StringBuilder();

    Node temp = head;
    System.out.print("[");

    while(temp != null){
        result.append(temp.data);
        if(temp.next != null) {
            result.append(" -> ");
        }
        temp = temp.next;
    }

    return result.append("]").toString();
}

private static class Node{
private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

    public static void main(String[] args) {
    SinglyLinkedList linkedList = new SinglyLinkedList();
    linkedList.insert(18);
        System.out.println(linkedList);
        for (int i = 0; i < 5; i++) {
            linkedList.insert(i+1);
        }


       /* Node temp = linkedList.head;
        while(temp != null){
            if(temp.data == 5){
                linkedList.insertAfter(42,temp);
                break;
            }
            temp=temp.next;
        }*/
         linkedList.remove(1);

        System.out.println(linkedList);
        System.out.println(linkedList.size);
        System.out.println(linkedList.search(2));


    }


}
