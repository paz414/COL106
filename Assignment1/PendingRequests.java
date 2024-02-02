import Includes.*;
public class PendingRequests {
    private int length = 0;
    public Node<RequestData> front; // made both front and back public so that Class LibraryStorage can use'em
    public Node<RequestData> back;

    public boolean insert(Node<RequestData> insnode) {
        Node<RequestData> newNode=new Node<RequestData>();
        newNode.data=insnode.data;
        if(front==null){
            front=newNode;
            back=newNode;
            length++;
            return true;
        }
        back.next=newNode;
        newNode.previous=back;
        back=newNode;
        length++;
        return true;
    }

    public boolean delete(Node<RequestData> delnode) {
        if(delnode==front){
            front=front.next;
            front.previous=null;
        }
        else if(delnode==back){
            back=back.previous;
            back.next=null;
        }
        else{
            delnode.previous.next=delnode.next;
            delnode.next.previous=delnode.previous;
        }
        length--;
        return true;
    }

    public Node<RequestData> find(int ISBN) {
        Node<RequestData> temp=front;
        while(temp!=null){
            if(temp.data.ISBN==ISBN)
                break;
            temp=temp.next;
        }
        return temp;
    }

    public String toString(){
        Node<RequestData> temp = front;
        String s = "Length: " + length + "\n";
        while(temp != null){
            s+=temp.data.toString();
            temp = temp.next;
        }
        return s;
    }
}
