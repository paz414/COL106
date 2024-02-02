import java.util.*;
import Includes.*;
public class LibraryStorage {
    // HashMap
    // process return
    private HashMap<Integer, BookData> storage;
    private RequestQueue rqQueue;
    private PendingRequests prLinkedList;

    public LibraryStorage() {   //available books in the library storage
        storage = new HashMap<Integer, BookData>();
        for (int i=100001; i<100011; i++) {
            BookData book = new BookData();
            MyDate dateor = new MyDate();
            dateor.month = 0;
            dateor.year = 0;
            book.BorrowedStatus = false;
            book.BorrowedByUserID = 0;
            book.ISBN = i;
            book.Publisher = "publisher";
            book.Author = "author";
            book.DateOfReturn = dateor;
            storage.put(i, book);
        }

        rqQueue = new RequestQueue();
        prLinkedList = new PendingRequests();
    }

    public void push(int ISBN, int UserID) { //pushing requests into the queue
        rqQueue.push(ISBN, UserID);
    }

    public boolean processQueue() { //processing requests and figuring which ones to add to the pending requests
        if (storage.get(rqQueue.getFront().ISBN)!=null && !storage.get(rqQueue.getFront().ISBN).BorrowedStatus) {
            storage.get(rqQueue.getFront().ISBN).BorrowedStatus=true;
            storage.get(rqQueue.getFront().ISBN).BorrowedByUserID = rqQueue.getFront().UserID;
            rqQueue.pop();
            return true;
        }
        else if (storage.get(rqQueue.getFront().ISBN)!=null && storage.get(rqQueue.getFront().ISBN).BorrowedStatus) {
            prLinkedList.insert(rqQueue.front1);
            rqQueue.pop();
            return false;
        }
        else {
            rqQueue.pop();
            return false;
        }
    }
    public boolean processReturn(BookData book) {          // I have assumed this takes Includes.BookData object as argument, can also work with ISBN perhaps
        if(prLinkedList.find(book.ISBN).data.ISBN==book.ISBN){
            prLinkedList.delete(prLinkedList.find(book.ISBN));
            storage.get(book.ISBN).BorrowedStatus=true;
            storage.get(book.ISBN).BorrowedByUserID = book.BorrowedByUserID;
            return true;
        }
        else{
            storage.get(book.ISBN).BorrowedStatus=false;
            storage.get(book.ISBN).BorrowedByUserID = -1;
            return false;
        }
    }

    public String rqQueueToString(){
        return rqQueue.toString();
    }

    public String prLinkedListToString(){
        return prLinkedList.toString();
    }
    
}
