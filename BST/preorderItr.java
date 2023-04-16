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

  public void preorder(Node root) {
    if(root == null) {
      return;
    }
    Stack<Node> st = new Stack<>();
    Node temp = root;
    while(temp != null || !st.isEmpty()) {
      while(temp != null) {
        System.out.print(temp.data+" ");
        st.push(temp);
        temp = temp.left;
      }
      temp = st.pop();
      temp = temp.right;
    }
  }

  public static void main(String[] args) {
      Bst b = new Bst();
      b.root = b.insert(10);
      b.insert(20);
      b.insert(30);
      b.insert(5);
      b.preorder(b.root);
  }
}
