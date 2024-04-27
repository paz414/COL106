import java.util.*;
public class StableBucketSort {
    public ArrayList<ArrayList<Integer>> sort(ArrayList<ArrayList<Integer>> nums){
        int max=0;
        for (ArrayList<Integer> num : nums) {
            if (max < num.get(0))
                max = num.get(0);
        }
        int []freq=new int[max+1];
        for (ArrayList<Integer> num : nums) freq[num.get(0)]++;
        for(int i=1;i<freq.length;i++)
            freq[i]+=freq[i-1];
        ArrayList<ArrayList<Integer>> res=new ArrayList<>(nums);
        for(int i=nums.size()-1;i>=0;i--){
            res.set(--freq[nums.get(i).get(0)],nums.get(i));
        }
        return res;
    }
    public static void main(String[] args) {
        StableBucketSort sbs = new StableBucketSort();
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        //creating this list of lists
        //[[2,4], [2,6], [1,10], [1,5], [1,7]]
        nums.add(new ArrayList<>(Arrays.asList(2,4)));
        nums.add(new ArrayList<>(Arrays.asList(2,6)));
        nums.add(new ArrayList<>(Arrays.asList(1,10)));
        nums.add(new ArrayList<>(Arrays.asList(1,5)));
        nums.add(new ArrayList<>(Arrays.asList(1,7)));
        ArrayList<ArrayList<Integer>> res = sbs.sort(nums);
        //Expected output:[[1, 10], [1, 5], [1, 7], [2, 4], [2, 6]]
        System.out.println(res);
    }
}
