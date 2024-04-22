import java.util.*;
public class LongestCommonPrefix{
    public String LCP(String[] strs) {
        Arrays.sort(strs); //sorts the string array lexicographically
        String prefix = "";
        for(int i=0;i<strs[0].length();i++){
            if(strs[0].charAt(i)==strs[strs.length-1].charAt(i))//if the first and last string have the
                                                                // same character at the same index
                prefix+=strs[0].charAt(i);
            else
                break;
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"sadadadaghjt", "sadadadaghjt", "sadadaghjt", "sadadadadadadaghjt"};
        System.out.println(lcp.LCP(strs));
    }
}
//Honestly idk why anyone would use KMP. 
