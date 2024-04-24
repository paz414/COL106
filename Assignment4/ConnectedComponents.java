import java.util.*;
public class ConnectedComponents {
    public int NumCktdComp(int n, Vector<Vector<Integer>> adj) {
        if(findMin(adj)!=0)
            fix(adj,findMin(adj));
        int c=0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                dfs(i,adj,visited);
            }
        }
        return c;
    }
    public void dfs(int i,Vector<Vector<Integer>> adj,boolean[] visited){
        visited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            if(!visited[adj.get(i).get(j)])
                dfs(adj.get(i).get(j),adj,visited);
        }
    }
    public void fix(Vector<Vector<Integer>> adj,int min){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++)
                adj.get(i).set(j,adj.get(i).get(j)-min);
        }
    }
    public int findMin(Vector<Vector<Integer>> adj){
        int min=adj.get(0).get(0);
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                if(min>adj.get(i).get(j))
                    min=adj.get(i).get(j);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ConnectedComponents cc = new ConnectedComponents();
        //Constructing this adjacent list: [[4,9], [8,11,14], [6,13], [], [0,9], [10,13],
        //[2,10], [12], [1,14], [0,4], [5,6], [1,14], [7], [2,5], [1,
        //8,11]]
        //The answer should be 5
        Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
        adj.add(new Vector<>(Arrays.asList(4,9)));
        adj.add(new Vector<>(Arrays.asList(8,11,14)));
        adj.add(new Vector<>(Arrays.asList(6,13)));
        adj.add(new Vector<>());
        adj.add(new Vector<>(Arrays.asList(0,9)));
        adj.add(new Vector<>(Arrays.asList(10,13)));
        adj.add(new Vector<>(Arrays.asList(2,10)));
        adj.add(new Vector<>(Arrays.asList(12)));
        adj.add(new Vector<>(Arrays.asList(1,14)));
        adj.add(new Vector<>(Arrays.asList(0,4)));
        adj.add(new Vector<>(Arrays.asList(5,6)));
        adj.add(new Vector<>(Arrays.asList(1,14)));
        adj.add(new Vector<>(Arrays.asList(7)));
        adj.add(new Vector<>(Arrays.asList(1,8,11)));
        adj.add(new Vector<>(Arrays.asList(2,5)));
        System.out.println(cc.NumCktdComp(15, adj));

    }
}
