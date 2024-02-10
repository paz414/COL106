class MyLinkedList
{
    int length=0;
    class Node
    {
        int val;
        Node next;
        Node(int val)
        {
            this.val=val;
            this.next=null;
        }
    }
    Node head;
    Node tail;
    public MyLinkedList()
    {this.length=0;
    }
    public int get(int index)
    {
        if(index<0 || index>=length)
            return -1;
        Node temp=head;
        for(int i=0;i<index;i++)
            temp=temp.next;
        return temp.val;
    }

    public void addAtHead(int val)
    {
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(head.next==null)
            tail=head;
        length++;
    }

    public void addAtTail(int val)
    {
        if (tail==null)
        {
            addAtHead(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if(index<0 || index>length)
            return;
        if(index==0)
        {
            addAtHead(val);
            return;
        }
        if(index==length)
        {
            addAtTail(val);
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++)
            temp=temp.next;
        Node node=new Node(val);
        node.next=temp.next;
        temp.next=node;
        length++;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>=length)
            return;
        if(index==0)
        {
            head=head.next;
            if(head==null)
                tail=null;
            length--;
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++)
            temp=temp.next;
        temp.next=temp.next.next;
        if(temp.next==null)
            tail=temp;
        length--;
    }
}
