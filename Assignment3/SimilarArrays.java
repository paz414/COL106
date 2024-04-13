import java.util.*;
public class SimilarArrays {
    public int minSteps(int[] A, int[] target) {
        int n = A.length;
        int AOdd = countOdd(A);
        int targetOdd = countOdd(target);
        if(sum(A) != sum(target)){return -1;}
        if (AOdd != targetOdd) {return -1;}
        int[] sortedA = sort(A);
        int[] sortedTarget = sort(target);
        int decrease=0;
        List<Integer> evenA = new ArrayList<>(), oddA = new ArrayList<>(), evenT = new ArrayList<>(), oddT = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(sortedA[i]%2==0) evenA.add(sortedA[i]);
            else oddA.add(sortedA[i]);
            if(sortedTarget[i]%2==0) evenT.add(sortedTarget[i]);
            else oddT.add(sortedTarget[i]);
        }
        for(int i=0;i<evenA.size();i++) { if(evenA.get(i)>evenT.get(i)) decrease+=(evenA.get(i)-evenT.get(i)); }
        for(int i=0;i<oddA.size();i++) { if(oddA.get(i)>oddT.get(i)) decrease+=(oddA.get(i)-oddT.get(i)); }
        return decrease/2;
    }
    private int countOdd(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                count++;
            }
        }
        return count;
    }
    private int sum(int []arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    private int[] sort(int []a) {
        List<Integer> list = convertToList(a);
        Collections.sort(list);
        return convertToArray(list);

    }
    public List<Integer> convertToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
    public int[] convertToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
