class CustomStack {
    private int arr[];
    private int length=0;
    public CustomStack(int maxSize) {
        arr=new int[maxSize];
    }
    
    public void push(int x) {
        if(length<arr.length){
            arr[length]=x;
            length++;
        }
    }
    
    public int pop() {
        if(length==0)
            return -1;
        else
            length--;
            return arr[length];
    }
    
    public void increment(int k, int val) {
        k=Math.min(length,k);
        for(int i=0;i<k;i++)
            arr[i]+=val;
    }
}
