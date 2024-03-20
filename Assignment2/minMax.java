import java.util.*;
public class minMax{
    public class Node{
        public int data = 0;
        public Node parent = null;
        public Node leftChild = null;
        public Node rightChild = null;

        public Node(int d){
            data = d;
        }
    }

    public class BST{
        public Node root = null;
    }

    public BST bst = new BST();
    public Vector<Integer> in;
    public Vector<Vector<Integer>> minMaxResult(Vector<Integer> queries) {
        in=new Vector<Integer>();
        inorder(bst.root);
        Vector<Vector<Integer>> answer = new Vector<Vector<Integer>>();
        for (int i = 0; i < queries.size(); i++) {
            Vector<Integer> temp = new Vector<Integer>();
            temp.add(greatestLessThanX(queries.get(i)));
            temp.add(smallestMoreThanX(queries.get(i)));
            answer.add(temp);
        }
        return answer;
    }
    public int greatestLessThanX(int x){
        for(int i=in.size()-1;i>=0;i--){
            if(in.get(i)<=x)
                return in.get(i);
        }
        return -1;
    }
    public int smallestMoreThanX(int x){
        for(int i=0;i<in.size();i++){
            if(in.get(i)>=x)
                return in.get(i);
        }
        return -1;
    }
    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.leftChild);
        in.add(root.data);
        inorder(root.rightChild);
    }

    public static void main(String[] args){
        minMax Tree = new minMax();

        //Test 1:
        minMax.Node rootNode = Tree.new Node(14);
        Tree.bst.root = rootNode;

        minMax.Node node1 = Tree.new Node(7);
        node1.parent = Tree.bst.root;
        Tree.bst.root.leftChild = node1;

        node1 = Tree.new Node(19);
        node1.parent = Tree.bst.root;
        Tree.bst.root.rightChild = node1;

        node1 = Tree.new Node(3);
        node1.parent = Tree.bst.root.leftChild;
        Tree.bst.root.leftChild.leftChild = node1;

        node1 = Tree.new Node(9);
        node1.parent = Tree.bst.root.leftChild;
        Tree.bst.root.leftChild.rightChild = node1;

        node1 = Tree.new Node(16);
        node1.parent = Tree.bst.root.rightChild;
        Tree.bst.root.rightChild.leftChild = node1;

        node1 = Tree.new Node(23);
        node1.parent = Tree.bst.root.rightChild;
        Tree.bst.root.rightChild.rightChild = node1;

        node1 = Tree.new Node(20);
        node1.parent = Tree.bst.root.rightChild.rightChild;
        Tree.bst.root.rightChild.rightChild.leftChild = node1;

        Vector<Integer> queries = new Vector<Integer>();
        queries.add(7);
        queries.add(12);
        queries.add(24);
        Vector<Vector<Integer>> answer = Tree.minMaxResult(queries);

        System.out.println("Returned answer: " + answer);
        System.out.println("Expected answer: [[7, 7], [9, 14], [23, -1]]");

        //Test 2:
        rootNode = Tree.new Node(13);
        Tree.bst.root = rootNode;

        node1 = Tree.new Node(19);
        node1.parent = Tree.bst.root;
        Tree.bst.root.rightChild = node1;

        queries.clear();
        queries.add(9);
        answer = Tree.minMaxResult(queries);

        System.out.println("Returned answer: " + answer);
        System.out.println("Expected answer: [[-1, 13]]");

    }
}
