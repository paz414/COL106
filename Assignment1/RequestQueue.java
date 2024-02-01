import Includes.*;
public class RequestQueue {
    public Node<RequestData> front1;
    public Node<RequestData> back1;
    public int length = 0;

    public RequestData getFront() {
        return this.front1.data;
    }

    public int getLength() {
        Node<RequestData> temp=front1;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return this.length;
    }

    public void push(int ISBN, int UserID) {
        Node<RequestData> temp=new Node<RequestData>();
        temp.data= new RequestData();
        temp.data.ISBN=ISBN;
        temp.data.UserID=UserID;
        temp.data.RequestDate=new MyDate();
        if(front1==null){
            front1=temp;
            back1=temp;
        }
        else{
            back1.next=temp;
            temp.previous=back1;
            back1=temp;
        }
        length++;
    }

    public void pop() {      // processing needs to be done before popping, 
        if(front1==null)
            return;
        else if(front1==back1){
            front1=null;
            back1=null;
        }
        else{
            front1=front1.next;
            front1.previous=null;
        }
        length--;
    }

    public String toString(){
        Node<RequestData> temp = front1;
        String s = "Length: " + length + "\n";
        while(temp != null){
            s+=temp.data.toString();
            temp = temp.next;
        }
        return s;
    }
}
