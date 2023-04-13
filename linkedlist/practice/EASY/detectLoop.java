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

  public boolean detectLoop(Node head){
    if(head == null) {
      return false;
    }
    Node slow = head;
    Node fast = head.next;
    while(fast != null && fast.next != null) {
        if(slow == fast) {
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = new Node(10);
    Node n1 = new Node(20);
    Node n2 = new Node(30);
    Node n3 = new Node(40);
    l1.head.next = n1;
    n1.next = n2;
    n2.next = n3;
    // n3.next = l1.head;
    n3.next = null;
    System.out.println("LOOP: " + l1.detectLoop(l1.head));
  }
}

