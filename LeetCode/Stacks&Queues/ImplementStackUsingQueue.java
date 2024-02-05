class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
      public void push(int x) /* It's like transferring water from one glass to another. The top portion 
                                goes to the bottom and the bottom portion becomes the top*/
  {     while(!q1.isEmpty())
            q2.add(q1.remove());
        q1.add(x);
        while(!q2.isEmpty())
            q1.add(q2.remove());
    }
    
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
