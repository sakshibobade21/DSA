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

  public Node addTwoLists(Node first, Node second){
    Node curr1 = first;
    Node curr2 = second;

    int temp1 = 0;
    int temp2 = 0;

    while(curr1 != null) {
      temp1 = temp1*10 + curr1.data;
      curr1 = curr1.next;
    }

    while(curr2 != null) {
      temp2 = temp2*10 + curr2.data;
      curr2 = curr2.next;
    }

    int temp3 = temp1+temp2;

    Node head = null;
    while(temp3 > 0) {
        int num = temp3 % 10;
        temp3 = temp3/10;
        Node n1 = new Node(num);
        if(head == null) {
          head = n1;
        } else {
          n1.next = head;
          head = n1;
        }
    }

    return head;
        
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = new Node(1);
    l1.addLast(9);
    l1.addLast(0);
    // l1.addLast(30);
    // l1.addLast(40);
    // l1.addLast(50);
    // l1.addLast(60);
    l1.print();
  
    LinkedList l2 = new LinkedList();
    l2.head = new Node(2);
    l2.addLast(5);
    // l2.addLast(70);
    l2.print();
    LinkedList l3 = new LinkedList();
    l3.head = l3.addTwoLists(l1.head, l2.head);
    l3.print();
  }
}

