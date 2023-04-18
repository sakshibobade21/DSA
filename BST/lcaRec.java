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

public Node LCA(Node root, int n1, int n2) {
  if(root == null) {
    return null;
  }

  if(n1 < root.data && n2 < root.data) {
    return LCA(root.left, n1, n2);
  }

  if(n1 > root.data && n2 > root.data) {
    return LCA(root.right, n1, n2);
  }

  return root;
  
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
    // b.inorder(b.root);
    Node n = b.LCA(b.root, 30, 50);
    System.out.println(n.data);
  }
}
