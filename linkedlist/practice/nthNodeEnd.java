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

  public int nthNode(Node head, int n) {
    if(head == null) {
      return 0;
    }
    int i = 1;
    Node curr = head;
    while(n != i && curr != null) {
      curr = curr.next;
      i++;
    }
    if(curr == null) {
        return 0;
    }
    Node temp = head;
    while(curr != null) {
      curr = curr.next;
      if(curr == null) {
        return temp.data;
      }
      temp = temp.next;
    }
    return 0;
  }  
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = l1.new Node(10);
    l1.addLast(20);
    l1.addLast(30);
    l1.addLast(40);
    l1.addLast(50);
    l1.print();
    System.out.println("NODE: "+ l1.nthNode(l1.head, 2));
  }
}

