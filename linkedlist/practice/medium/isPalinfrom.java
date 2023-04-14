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

  public Node reverse(Node head) {
    Node curr = head;
    if(head == null || head.next == null) {
      return head;
    }
    Node next = curr.next;
    Node prev = null;
    while(curr != null) {
        curr.next = prev;
        prev = curr;
        curr = next;
        if(next != null) {
          next = curr.next;
        } else {
          head=prev;
          return prev;
        }
    }
    return prev;
  }

  public int isPalindrom(Node head) {
    Node curr = head;
    int len = 0;
    int mid = 0;
    while(curr != null) {
      len++;
      curr = curr.next;
    }
    mid = ((len % 2) == 0) ? len/2 : len/2 + 1;
    curr = head;
    int trace = 1;
    while(trace < mid) {
      trace++;
      curr = curr.next;
    }
    curr.next = reverse(curr.next);
    
    Node temp = curr.next;
    Node h = head;
    while(temp != null) {
      if(h.data != temp.data) {
        return 0;
      }
      h = h.next;
      temp = temp.next;
    }
    return 1;
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = new Node(10);
    l1.addLast(20);
    l1.addLast(30);
    l1.addLast(30);
    l1.addLast(20);
    l1.addLast(10);
    l1.addLast(10);
    // l1.addLast(70);
    l1.print();
    System.out.println(l1.isPalindrom(l1.head));
    // l1.head = l1.reverse(l1.head);
    // l1.print();
  }
}

