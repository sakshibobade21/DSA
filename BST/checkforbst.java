import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  Node(int d) {
    data = d;
    left = null;
    right = null;
  }
}

class Bst {

  Node root = null;

  public Node insert(int data) {
    Node newNode = new Node(data);
    if(root == null) {
      root = newNode;
      return root;
    }
    Node prev = null;
    Node temp = root;
    while(temp != null) {
      prev = temp;
      if(temp.data > data) {
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }

    if(prev.data > data) {
      prev.left = newNode;
    } else {
      prev.right = newNode;
    }

    return root;
  }

  public boolean inorder(Node root) {
    Stack<Node> st = new Stack<>();
    if(root == null) {
      return false;
    }
    Node curr = root;
    Node prev = root;
    while(curr != null || !st.isEmpty()) {
      while(curr != null) {
        st.push(curr);
        curr = curr.left;
      }
      Node item = st.pop();
      System.out.print(item.data+" ");
      curr = item.right;
    }
    System.out.println();
    return true;
  }

  public boolean checkIfBst(Node root) {
    Stack<Node> st = new Stack<>();
    if(root == null) {
      return false;
    }
    Node curr = root;
    Node prev = null;
    while(curr != null || !st.isEmpty()) {
      while(curr != null) {
        st.push(curr);
        curr = curr.left;
      }
      Node item = st.pop();
      if(prev!= null && prev.data > item.data) {
        return false;
      }
      prev = item;
      curr = item.right;
    }
    return true;
  }

  public static void main(String[] args) {
      Bst b = new Bst();
      b.root = b.insert(10);
      b.insert(20);
      b.insert(30);
      b.insert(5);
      b.insert(1);
      b.insert(50);
      b.insert(25);
      b.inorder(b.root);
      b.root.right.right = new Node(90);
      b.checkIfBst(b.root);
  }
}
