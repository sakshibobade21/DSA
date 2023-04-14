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

  public int intersectPoint(Node head1, Node head2) {
    if(head1 == null || head2 == null) {
      return 0;
    }
    Node curr = head1;
    int len1 = 0;
    int len2  = 0;
    while(curr != null) {
      len1++;
      curr = curr.next;
    }
    curr = head2;
    while(curr != null) {
      len2++;
      curr = curr.next;
    }
    Node curr1 = head1;
    Node curr2 = head2;
    if(len1 > len2) {
       int diff = len1-len2;
       int i = 0;
       while(i != diff) {
        i++;
        curr1 = curr1.next;
       }
    } else {
      int diff = len2-len1;
      int i = 0;
      while(i != diff) {
        i++;
        curr2 = curr2.next;
      }
    }
    while(curr1 != null && curr2 != null) {
      if(curr1 == curr2) {
        return curr1.data;
      }
      curr1 = curr1.next;
      curr2 = curr2.next;
    }

    return -1;
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
  
    LinkedList l2 = new LinkedList();
    l2.head = new Node(90);
    l2.addLast(80);
    l2.addLast(70);
    l2.head.next.next.next = l1.head;
    l2.print();
    l1.intersectPoint(l1.head, l2.head);
  }
}

