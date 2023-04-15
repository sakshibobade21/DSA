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
    Node n2 = new Node(10);
    Node n3 = new Node(11);
    Node n4 = new Node(12);
    newNode.left = n2;
    newNode.right = n3;
    n2.left = n4;
    return newNode;
  }

  public void inorder(Node root) {
    if(root == null) {
        return;
    }
    Stack<Node> stack = new Stack<>();

    Node temp = root;
    while(temp != null || !stack.isEmpty()) {
      while(temp != null) {
        stack.push(temp);
        temp = temp.left;
      }
      temp = stack.pop();
      System.out.print(temp.data+" ");
      temp = temp.right;
    }

  }

  public static void main(String[] args) {
      Bst b = new Bst();
      b.root = b.insert(0);
      b.inorder(b.root);
  }
}
