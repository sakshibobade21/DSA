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

  public void search(int data) {
    if(root == null) {
      System.out.print("Does not exists");
      return;
    }
    Node curr = root;
    while(curr != null) {
      if(curr.data == data) {
        System.out.print("Exists");
        return;
      } else if(curr.data > data) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    System.out.print("notexists");
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
      b.search(599);
  }
}
