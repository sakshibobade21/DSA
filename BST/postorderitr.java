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

  public void postorder(Node root) {
    if(root == null) {
      return;    
    }
    Node curr = root;
    Node temp = null;
    Stack<Node> st = new Stack<>();
    while(curr != null || !st.isEmpty()) {
      while(curr != null) {
        // System.out.println(curr.data);
        st.push(curr);
        curr = curr.left;
      }
      temp = st.peek().right;
      if(temp != null) {
        curr = temp;
      } else {
        temp = st.pop();
        System.out.print(temp.data + " ");
        while(!st.isEmpty() && st.peek().right == temp) {
          temp = st.pop();
          System.out.print(temp.data+ " ");
        }
        curr = null;
      }
    }

    
  }

  public static void main(String[] args) {
      Bst b = new Bst();
      b.root = b.insert(10);
      b.insert(20);
      b.insert(30);
      b.insert(5);
      b.postorder(b.root);
  }
}
