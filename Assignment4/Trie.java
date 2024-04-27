import java.util.*;
public class Trie {
    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;
        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
        Node get(char ch) {
            return links[ch - 'a'];
        }
        void setEnd() {
            flag = true;
        }
        boolean isEnd() {
            return flag;
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }
    //creating the trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    //finding suggestions for each word
    public List<String> suggestion(String entry, Trie trie) {
        Node node = trie.root;
        for (int i = 0; i < entry.length(); i++) {
            if (!node.containsKey(entry.charAt(i))) {
                return new ArrayList<>();
            }
            node = node.get(entry.charAt(i));
        }
        return traverse(entry, node);
    }
    //traversing throught the trie
    public static List<String> traverse(String entry, Node node) {
        List<String> res = new ArrayList<>();
        if (node.isEnd()) {
            res.add(entry);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (node.containsKey(i)) {
                String temp = entry + i;
                res.addAll(traverse(temp, node.get(i)));
            }
        }
        return res;
    }
    //main method to test the code
    //
    //
    public static void main(String[] args) {
        Trie trie=new Trie();
        String []feed={"monkey","mouse","moneypot","monitor","mousepad"};
        String []queries={"m","mon","t", "mouse"};
        for(String s:feed) //feeding the trie with the inputs given
            trie.insert(s);
        for(String s:queries){ //searching for the relevant suggestions for the given queries
            List<String> res=trie.suggestion(s,trie);
            System.out.print("Suggestions for "+s+" are: ");
            for(String r:res)
                System.out.print(r+" ");
            System.out.println();
        }
    }
}
                            
                        

