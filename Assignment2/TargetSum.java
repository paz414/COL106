import java.util.*;
public class TargetSum {
    public int numberOfPairs(int arr[], int target) {
        int count=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(h.containsKey(target-arr[i]) && 2*arr[i]!=target)//checks whether target sum is even possible with the current number and that the number is not half the target since that would mean "repetition"
                count+=h.get(target-arr[i]); // Adding number of occurences of (target-arr[i]) to account for each possibility
                count=count%1000000007;
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        return count;
    }
    
}
/* Line 10 is really important 
it refers consists of two parts 
First part,"h.getOrDefault(arr[i],0)+1" 
in the hashmap we are using the "value" to count the number of 
occurence of arr[i] in the array
Second part, h.put(arr[i],....) this adds a new element with
the same key arr[i] but a different value that is the updated 
number of occurences of the element arr[i] */
