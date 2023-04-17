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

 public Node findLargest(Node node) {
   if(node == null) {
     return null;
   }
   Node prev = node;
   while(node != null) {
     prev = node;
     node = node.right;
   }
   return prev;
 }

  public void delete(int data) {
    if(root == null) {
      System.out.println("notexists");
      return;
    }
    Node curr = root;
    Node prev = null;
    while(curr != null) {
      if(curr.data == data) {
        System.out.println("Exists ");
        // Leaf Node
        if(curr.left == null && curr.right == null) {
          if(prev.data > curr.data) {
            prev.left = null;
          } else {
            prev.right = null;
          }
          return;
        }
        // Single Child
        if(curr.left == null || curr.right == null) {
          if(curr.left != null) {
            if(curr.left.data > prev.data) {
              prev.right = curr.left;
            } else {
              prev.left = curr.left;
            }
            return;
          }
          if(curr.right != null) {
            if(curr.right.data > prev.data) {
              prev.right = curr.right;
            } else {
              prev.left = curr.right;
            }
            return;
          }
        } else {
          // Two children
          Node n1 = findLargest(curr.left);
          n1.right = curr.right;
          curr.right = null;
          curr.left = null;
          if(prev == null) {
            root = n1;
          } else {
            if(prev.data > n1.data) {
              prev.left = n1;
            } else {
              prev.right = n1;
            }
          }
          return;
        }
      } else if(curr.data > data) {
        prev = curr;
        curr = curr.left;
      } else {
        prev = curr;
        curr = curr.right;
      }
    }
    System.out.println("notexists ");
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
      b.delete(10);
      b.inorder(b.root);
  }
}
