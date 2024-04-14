import java.util.*;
public class maxMST {
    public class Node{
        Vector<Integer> keys = new Vector<Integer>();
        Vector<Node> children = new Vector<Node>();
    }
    // for a whole subtree it, stores it's max & min values and max sum of all keys of a valid MST subtree
    private static class Data {
        public boolean bool_ = false; // stores whether the whole subtree is a valid MST or not
        public int sum = 0, max_ = Integer.MIN_VALUE, min_ = Integer.MAX_VALUE;
    }

    private static Data isSorted (Vector<Integer> vec) {
        Data ans = new Data();
        for (int i = 0; i < vec.size(); i++) {
            // not returning sum, max_ & min_ because these values of an invalid MST subtree has no value for parent nodes
            if (i != 0 && vec.get(i - 1) >= vec.get(i)) return new Data(); // "==" is also invalid, since in a MST we can only have distinct keys
            ans.sum += vec.get(i);
            if (vec.get(i) > ans.max_) ans.max_ = vec.get(i);
            if (vec.get(i) < ans.min_) ans.min_ = vec.get(i);
        }
        ans.bool_ = true;
        // if valid MST subtree then returning all useful info, i.e. sum, min_, max_
        return ans;
    }

    // sum, max_, min_, has no useful info for it's parents if current node or it's childrens are not valid
    private static Data fun (Node node) {
        // all the cases are just checking if the properties of 2-4 tree are being held
        Data ans = isSorted(node.keys);
        int sum = ans.sum, childMax = 0;
        // in a valid MST subtree we can't have empty node, or node with more than 3 keys
        if (node.keys.isEmpty() || node.keys.size() > 3) ans.bool_ = false;
        // in a valid MST internal nodes should have number of keys + 1 children, i.e. 1 key => 2 children, 2 key => 3 children & 3 key => 4 children
        if (!node.children.isEmpty() && node.keys.size() + 1 != node.children.size()) ans.bool_ = false;
        for (int i = 0; i < node.children.size(); i++) {
            Data childAns = fun(node.children.get(i));
            sum += childAns.sum;
            if (childAns.sum > childMax) childMax = childAns.sum;
            ans.bool_ &= childAns.bool_;
            // for a valid MST, max_ of left child of key should be strcictly less than the key & min_ of right child of a key should be strictly greater than the key
            if (i < node.keys.size() && childAns.max_ >= node.keys.get(i)) ans.bool_ = false;
            if (i == node.keys.size() && childAns.min_ <= node.keys.get(i - 1)) ans.bool_ = false;
        }
        ans.sum = (ans.bool_ ? sum : childMax);
        return ans;
    }

    public static int getMaxMST(Node node){
        return fun(node).sum;
    }
    public static void main(String args[]){

        // Test Case 1:
        maxMST tree = new maxMST();
        Node root = tree.new Node();
        root.keys.add(10);
        root.keys.add(20);
        Node temp = tree.new Node();
        temp.keys.add(2);
        temp.keys.add(4);
        root.children.add(temp);
        temp = tree.new Node();
        temp.keys.add(15);
        root.children.add(temp);
        temp = tree.new Node();
        temp.keys.add(22);
        temp.keys.add(25);
        root.children.add(temp);
        int ans = getMaxMST(root);
        System.out.println(ans);
    }
}
//Code stolen from Sahil Beck's Github
