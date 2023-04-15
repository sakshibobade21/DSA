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

  public Node rotate(Node head, int k) {
    if(head == null || head.next == null) {
      return head;
    }
    Node curr = head;
    Node newHead = head;
    Node last = head;
    int i = 0;
    while(last.next != null) {
      last = last.next;
    }
    while(i != k && curr != null) {
      last.next = curr;
      last = curr;
      newHead = curr.next;
      curr.next = null;
      curr = newHead;
      i++;
    }
    return curr;
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = new Node(10);
    l1.addLast(20);
    l1.addLast(30);
    l1.addLast(40);
    l1.addLast(50);
    l1.addLast(60);
    l1.print();
    l1.head = l1.rotate(l1.head, 3);
    l1.print();
  }
}

