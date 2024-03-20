import java.util.*;
public class MedianHeap {
    int size = 0;
    int minHeapSize = 0, maxHeapSize = 0;
    int minHeap[];
    int maxHeap[];
    MedianHeap(int x) {
        size = x;
        minHeap = new int[size];
        maxHeap = new int[size];
        for (int i=0; i<size; i++) {
            minHeap[i] = -1;
            maxHeap[i] = -1;
        }
    }
    public int returnMedian(int x) {
        if(minHeapSize==maxHeapSize)
        {
            if(x>minHeap[0])
            {
                minInsert(x);
                return minHeap[0];
            }
            else
            {
                maxInsert(x);
                return maxHeap[0];
            }
        }
        else if(maxHeapSize>minHeapSize)
        {
            if(x>maxHeap[0])
            {
                minInsert(x);
                return (maxHeap[0]+minHeap[0])/2;
            }
            else
            {
                minInsert(maxHeap[0]);
                maxInsert(x);
                deleteTopMaxHeap();
                return (maxHeap[0]+minHeap[0])/2;
            }
        }
        else
        {
            if(x<minHeap[0]) {
                maxInsert(x);
                return (maxHeap[0]+minHeap[0])/2;
            }
            else {
                maxInsert(minHeap[0]);
                minInsert(x);
                deleteTopMinHeap();
                return (maxHeap[0]+minHeap[0])/2;
            }
        }
    }
    public int root(int index){
        return (index-1)/2;
    }
    public int left(int index){
        return 2*index+1;
    }
    public int right(int index){
        return 2*index+2;
    }
    public void minInsert(int val){

        minHeapSize++;
        minHeap[minHeapSize-1]=val;
        int ind=minHeapSize-1;
        while(ind>0 && minHeap[ind]<minHeap[root(ind)])
        {
            int t=minHeap[ind];
            minHeap[ind]=minHeap[root(ind)];
            minHeap[root(ind)]=t;
            ind=root(ind);
        }
    }
    public void maxInsert(int val){
        maxHeapSize++;
        maxHeap[maxHeapSize]=val;
        int ind=maxHeapSize;
        while(ind>0 && maxHeap[ind]>maxHeap[root(ind)])
        {
            int t=maxHeap[ind];
            maxHeap[ind]=maxHeap[root(ind)];
            maxHeap[root(ind)]=t;
            ind=root(ind);
        }
    }
    public void deleteTopMinHeap(){
        minHeap[0]=minHeap[minHeapSize-1];
        minDownHeapify();
        minHeapSize--;
    }
    public void deleteTopMaxHeap(){
        maxHeap[0]=maxHeap[maxHeapSize-1];
        maxDownHeapify();
        maxHeapSize--;
    }
    public void minDownHeapify(){
        int ind=0;
        while(right(ind)<minHeapSize){
            if(minHeap[ind]>Math.min(minHeap[left(ind)],minHeap[right(ind)]))
            {
                int t=minHeap[ind];
                minHeap[ind]=Math.min(minHeap[left(ind)],minHeap[right(ind)]);
                if(minHeap[left(ind)]<minHeap[right(ind)]){
                    minHeap[left(ind)]=t;
                    ind=left(ind);
                }
                else{
                    minHeap[right(ind)]=t;
                    ind=right(ind);
                }
            }
            else
                ind++;
        }
    }
    public void maxDownHeapify(){
        int ind=0;
        while(right(ind)<maxHeapSize){
            if(maxHeap[ind]<Math.max(maxHeap[left(ind)],maxHeap[right(ind)]))
            {
                int t=maxHeap[ind];
                maxHeap[ind]=Math.max(maxHeap[left(ind)],maxHeap[right(ind)]);
                if(maxHeap[left(ind)]>maxHeap[right(ind)]){
                    maxHeap[left(ind)]=t;
                    ind=left(ind);
                }
                else{
                    maxHeap[right(ind)]=t;
                    ind=right(ind);
                }
            }
            else
                ind++;
        }
    }
}

