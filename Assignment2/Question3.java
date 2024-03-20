import java.util.*;
public class deepestSubtree{
    public class Node{
        public int data = 0;
        public Node parent = null;
        public Vector<Node> children = new Vector<Node>();

        public Node(int d){
            data = d;
        }
    }
    public class Tree{
        public Node root = null;
    }

    public Tree tree = new Tree();

    public int maxNodeDepth(Node root){
        int maxDepth = 0;
        for(int i=0;i<root.children.size();i++){
            maxDepth = Math.max(maxDepth, maxNodeDepth(root.children.get(i))+1);
        }
        return maxDepth;
    }

    public Node deepestSubtreeNode(Node root) {
        Node temp = root;
        int maxDepth = maxNodeDepth(root);
        for(int i=1;i<=maxDepth;i++){
            if(helper(temp, maxDepth,i))
                return temp;
            temp=helper1(temp, maxDepth, i);
        }
        return temp;
    }
    public Node helper1(Node temp, int maxDepth, int i){
        for(int j=0;j<temp.children.size();j++){
            if(maxNodeDepth(temp.children.get(j))==maxDepth-i)
                return temp.children.get(j);
        }
        return temp;
    }
    public boolean helper(Node temp, int maxDepth, int i){
        int count=0;
        for(int j=0;j<temp.children.size();j++){
            if(maxNodeDepth(temp.children.get(j))==maxDepth-i)
                count++;
        }
        return count>1;
    }
    public static void main(String[] args){
        deepestSubtree Tree = new deepestSubtree();

        //Test 1:
        deepestSubtree.Node rootNode = Tree.new Node(0);
        Tree.tree.root = rootNode;
        System.out.println("Returned output: " + Tree.deepestSubtreeNode(Tree.tree.root).data);
        System.out.println("Expected output: 0");

        //Test 2:
        rootNode = Tree.new Node(1);
        Tree.tree.root = rootNode;
        deepestSubtree.Node node1 = Tree.new Node(2);
        node1.parent = Tree.tree.root;
        Tree.tree.root.children.add(node1);
        node1 = Tree.new Node(3);
        node1.parent = Tree.tree.root;
        Tree.tree.root.children.add(node1);
        node1 = Tree.new Node(4);
        node1.parent = Tree.tree.root;
        Tree.tree.root.children.add(node1);
        node1 = Tree.new Node(5);
        node1.parent = Tree.tree.root.children.get(0);
        Tree.tree.root.children.get(0).children.add(node1);
        node1 = Tree.new Node(6);
        node1.parent = Tree.tree.root.children.get(2);
        Tree.tree.root.children.get(2).children.add(node1);
        System.out.println("Returned output: " + Tree.deepestSubtreeNode(Tree.tree.root).data);
        System.out.println("Expected output: 1");

        //Test 3:
        node1 = Tree.new Node(7);
        node1.parent = Tree.tree.root.children.get(0).children.get(0);
        Tree.tree.root.children.get(0).children.get(0).children.add(node1);

        System.out.println("Returned output: " + Tree.deepestSubtreeNode(Tree.tree.root).data);
        System.out.println("Expected output: 7");
    }
}
