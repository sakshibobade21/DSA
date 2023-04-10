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
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }

  public void addEnd(int data) {
    Node newNode = new Node(data);
    Node curr = head;
    if(head == null) {
      head=newNode;
      return;
    }
    while(curr.next != null) {
      curr = curr.next;
    }
    newNode.next = curr.next;
    curr.next = newNode;
    newNode.prev = curr;
  }

  public void print() {
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.data+" -> ");
      curr = curr.next;
    }
    System.out.print("null");
  }

  public void addAfter(Node n, int data) {
    if(n == null) return;
    Node curr = head;
    Node newNode = new Node(data);
    while(curr.data != n.data) {
      curr = curr.next;
    }
    newNode.next = curr.next;
    curr.next.prev = newNode;
    curr.next = newNode;
    newNode.prev = curr;
  }

  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.addFront(30);
    l1.addFront(20);
    l1.addFront(10);
    // l1.addEnd(10);
    // l1.addEnd(20);
    // l1.addEnd(90);
    l1.addAfter(l1.head, 90);
    l1.print();
  }
}