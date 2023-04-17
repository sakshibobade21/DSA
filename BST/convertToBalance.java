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

public void addToVector(Vector<Node> vec, Node root) {
  if(root == null) {
    return;
  }
  Node curr = root;
  addToVector(vec, root.left);
  vec.add(curr);
  addToVector(vec, root.right);
}

public Node convert(Vector<Node> vec, int start, int end) {
  
  if(start > end) {
    return null;
  }

  int mid = (start + end)/2;
  Node node = vec.get(mid);

  node.left = convert(vec, start, mid-1);
  node.right = convert(vec, mid+1, end);

  return node;
}

public Node addToVector(Node root) {
  Vector<Node> vec = new Vector<>();
  addToVector(vec, root);

//   for(Node n: vec) {
//     System.out.print(n.data+" ");
//   }

  return convert(vec, 0, vec.size()-1);
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
    b.root = b.addToVector(b.root);
    b.inorder(b.root);
  }
}
