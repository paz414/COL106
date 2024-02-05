class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> l=new ArrayList<>();
        int k=0;
        for(int i=1;i<=n;i++){
            if(i==target[k]){
                l.add("Push");
                k++;
            }
            else
            {
                l.add("Push");
                l.add("Pop");
            }
            if(k==target.length)
                break;
        }
        return l;
    }
}
