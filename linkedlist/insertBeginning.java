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

  public void add(int data) {
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
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.add(10);
    l1.add(5);
    l1.print();
}
}

