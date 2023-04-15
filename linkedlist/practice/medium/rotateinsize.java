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

  public Node reverse(Node head, int k) {    
    
    Node curr = head;
    Node prev = null;
    Node nxt = null;
    int i = 0;
    while(curr != null) {
      while(i < k) {
        i++;
        Node temp = curr.next;
        curr.next = prev;
        te        
        curr = curr.next;
      }
      i = 0;
    }
    return null;
  }

  public Node rotate(Node first, Node last) {
    Node curr = first;
    Node temp = last.next;
    Node nxt = null;
    while(curr != last) {
      nxt = curr.next;
      last.next = curr;
      curr.next = temp;
      curr = nxt;
      temp = last.next;
    }
    return last;
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
    l1.head = l1.reverse(l1.head, 3);
    // l1.print();
  }
}

