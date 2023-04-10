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

  public void addLast(int data) {
    Node newNode = new Node(data);
    Node curr = head;
    if(curr == null) {
        head = newNode;
        return;
    }
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

  public void delHead() {
    if(head == null) {
      return;
    }
    Node curr = head;
    head = head.next;
    curr = null;
  }

   public static void main(String[] args) {
     LinkedList l1 = new LinkedList();
     l1.head = new Node(10);
     l1.addLast(20);
     l1.addLast(30);
     l1.print();
     l1.delHead();
     l1.print();
   }
}