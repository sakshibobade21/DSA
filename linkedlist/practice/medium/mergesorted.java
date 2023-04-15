class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}

class LinkedList {
  Node head;

  public void addHead(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    Node curr = head;
    while(curr.next != null) {
      curr = curr.next;
    }
    curr.next = newNode;
  }

  public void print() {
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.data + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public void printHead(Node h1) {
    Node curr = h1;
    while(curr != null) {
      System.out.print(curr.data + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public Node merge(Node head1, Node head2) {
    Node temp1 = head1;
    Node temp2 = head2;
    Node curr = null;

    if(temp1.data <= temp2.data) {
      curr = temp1;
      temp1 = temp1.next;
    } else {
      curr = temp2;
      temp2 = temp2.next;
    }
    Node newHead = curr;

    while(temp1 != null && temp2 != null) {
      if(temp1.data <= temp2.data) {
        curr.next = temp1;
        temp1 = temp1.next;
      } else {
        curr.next = temp2;
        temp2 = temp2.next;
      }
      curr = curr.next;
    }

    if(temp1 == null) {
      curr.next = temp2;
    } else if(temp2 == null){
      curr.next = temp1;
    }

    return newHead;
  }


  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = new Node(5);
    l1.addLast(10);
    l1.addLast(15);
    l1.addLast(40);
    l1.print();

    LinkedList l2 = new LinkedList();
    l2.head = new Node(2);
    l2.addLast(3);
    l2.addLast(20);
    l2.print();

    LinkedList l3 = new LinkedList();
    l3.head = l2.merge(l1.head, l2.head);
    l3.print();
  }
}

