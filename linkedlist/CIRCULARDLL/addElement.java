class Node {
  int data;
  Node prev;
  Node next;

  Node(int d) {
    data = d;
    prev = null;
    next = null;
  }
}

class LinkedList {
  Node head;

  public void addFront(int data) {
    Node newNode = new Node(data);

    if(head == null){
      head = newNode;
      head.next = newNode;
      head.prev = newNode;
      return;
    }

    newNode.next = head;
    head.prev = newNode;

    Node curr = head;
    while(curr.next != head) {
      curr = curr.next;
    }
    curr.next = newNode;
    newNode.prev = curr;
    head = newNode;
  }

  public void addEnd(int data) {
    Node newNode = new Node(data);
    if(head == null) {
      head = newNode;
      head.prev = head;
      head.next = head;
      return;
    }

    Node curr = head;
    while(curr.next != head) {
      curr = curr.next;
    }
    curr.next = newNode;
    newNode.prev = curr;
    newNode.next = head;
    head.prev = newNode;
  }
  

  public void print() {
    Node curr = head;
    while(curr.next != head) {
      System.out.print(curr.data+" -> ");
      curr = curr.next;
    }
    System.out.print(curr.data+" -> null");
  }


  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    // l1.addFront(40);
    // l1.addFront(30);
    // l1.addFront(20);
    // l1.addFront(10);
    l1.addEnd(10);
    l1.addEnd(20);
    l1.addEnd(90);
    l1.print();
  }
}