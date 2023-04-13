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

  public void deleteNode(Node del) {
    if(del == null) {
      return;
    }
    if(del.next != null) {
      del.data = del.next.data;
      del.next = del.next.next;
    } else {
      return;
    }
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = l1.new Node(10);
    l1.addLast(20);
    // l1.addLast(30);
    // l1.addLast(40);
    // l1.addLast(50);
    // l1.addLast(60);
    // l1.addLast(70);
    l1.print();
    l1.deleteNode(l1.head.next);
    l1.print();
  }
}

