public class IndirectKMP {
    public void LPS(String s,int M,int []lps) {
        int i=1;
        lps[0]=0;
        int len=0;
        while(i<M){
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0)
                    len=lps[len-1];
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
    public int CountToPalin(String s){
        String rev=reverse(s);
        String n=s+" "+rev;
        int M=n.length();
        int []lps=new int[M];
        LPS(n,M,lps);
        return s.length()-lps[M-1];
    }
    public String reverse(String s){
        String rev="";
        for(int i=0;i<s.length();i++)
            rev=s.charAt(i)+rev;
        return rev;
    }

    public static void main(String[] args) {
        IndirectKMP ob=new IndirectKMP();
        System.out.println(ob.CountToPalin("AACECAAA"));
    }
}
