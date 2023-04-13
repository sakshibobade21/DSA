import java.util.*;

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

  public void sort(Node head){
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Node curr = head;
    while(curr != null) {
      if(map.containsKey(curr.data)) {
        int count = map.get(curr.data);
        map.put(curr.data, count+1);
      } else {
        map.put(curr.data, 1);
      }
      curr = curr.next;
    }
    curr = head;
    int freqZ=0, freqO=0, freqT=0;
    while(curr != null) {
      if(map.containsKey(0)) {
        freqZ = map.get(0);
      }
      if(map.containsKey(1)) {
        freqO = map.get(1);
      }
      if(map.containsKey(2)) {
        freqT = map.get(2);
      }
      for(int i = 0; i < freqZ; i++) {
        curr.data = 0;
        curr = curr.next;
      }
      for(int i = 0; i < freqO; i++) {
        curr.data = 1;
        curr = curr.next;
      }
      for(int i = 0; i < freqT; i++) {
        curr.data = 2;
        curr = curr.next;
      }
    }
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.head = l1.new Node(1);
    l1.addLast(2);
    l1.addLast(0);
    l1.addLast(0);
    l1.addLast(2);
    l1.addLast(2);
    l1.addLast(1);
    l1.print();
    l1.sort(l1.head);
    l1.print();
  }
}

