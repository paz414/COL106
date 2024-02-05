class MinStack {
    Stack<Integer> s1;
    Stack<Integer> minStack;
    private int min;
    public MinStack() {
        s1=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        if(s1.isEmpty())
            minStack.push(val);
        else if(val<=minStack.lastElement())
            minStack.push(val);
        s1.push(val);
    }
    
    public void pop() {
        int lastmin=minStack.pop();
        int lastelement=s1.pop();
        if(lastmin!=lastelement)
            minStack.push(lastmin);
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return minStack.lastElement();
    }
}
