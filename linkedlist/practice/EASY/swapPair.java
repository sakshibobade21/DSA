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

  public Node swap(Node head) {
    if(head == null || head.next == null) {
        return head;
      }
      Node curr = head;
      Node next = curr.next;
      Node prev = null;
      head = next;
      while(next != null) {
        if(prev != null) {
          prev.next = next;
        }
        Node temp = next.next;
        next.next = curr;
        curr.next = temp;
        prev=curr;
        curr = temp;
        if(curr!=null) {
          next = curr.next;
        } else {
          next = null;
        }
      }
    return head;
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = l1.new Node(10);
    l1.addLast(20);
    l1.addLast(30);
    l1.addLast(40);
    l1.addLast(50);
    l1.addLast(60);
    l1.addLast(70);
    l1.print();
    l1.head = l1.swap(l1.head);
    l1.print();
  }
}

