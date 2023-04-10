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

  public void print() {
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.data + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public void addAfter(int d, Node n) {
    Node newNode = new Node(d);
    Node curr = head;
    while(curr != null && curr.data != n.data) {
    //   System.out.print("data:"+ curr.data);
      curr = curr.next;
    }
    newNode.next = curr.next;
    curr.next = newNode;
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = l1.new Node(10);
    Node secNode = l1.new Node(20);
    Node thrNode = l1.new Node(30);

    l1.head.next = secNode;
    secNode.next = thrNode;
    l1.addAfter(90, secNode);

    l1.print();
  }
}

