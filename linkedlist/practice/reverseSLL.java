class LinkedList {
  Node head;

  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

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

  public void reverseItr() {
    if(head == null) return;
    Node prev, curr, next;
    prev = null;
    curr = head;
    next = curr.next;
    while(curr != null) {
      curr.next = prev;
      prev = curr;
      curr = next;
      if(curr != null) {
        next = curr.next;
      }
    }
    head = prev;
  }

  public void reverseRec(Node prev, Node curr) {
    if(curr == null) {
      head = prev;
      return;
    }
    Node next = curr.next;
    curr.next = prev;
    reverseRec(curr, next);
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = l1.new Node(10);
    l1.addLast(20);
    l1.addLast(30);
    l1.addLast(40);
    l1.addLast(50);
    l1.print();
    l1.reverseItr();
    l1.print();
    l1.reverseRec(null, l1.head);
    l1.print();
  }
}

