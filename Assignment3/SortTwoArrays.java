public class sortTwoArrays{
    public static void sortBoth(int[] H, int[] W) {
        if (H.length > 1) {
            int mid = H.length / 2;
            int[] left1 = new int[mid];
            int[] left2 = new int[mid];
            int[] right1 = new int[H.length - mid];
            int[] right2 = new int[W.length - mid];

            for (int i = 0; i < mid; i++) {
                left1[i] = H[i];
                left2[i] = W[i];
            }

            for (int i = mid; i < H.length; i++) {
                right1[i - mid] = H[i];
                right2[i - mid] = W[i];
            }

            sortBoth(left1, left2);
            sortBoth(right1, right2);

            merge(H, W, left1, left2, right1, right2);
        }
    }

    private static void merge(int[] H, int[] W, int[] left1, int[] left2, int[] right1, int[] right2) {
        int i = 0, j = 0, k = 0;

        while (i < left1.length && j < right1.length) {
            if (left1[i] < right1[j]) {
                H[k] = left1[i];
                W[k] = left2[i];
                i++;
            }
            else if(left1[i]==right1[j]){
                if(left2[i]<right2[j]){
                    H[k] = left1[i];
                    W[k] = left2[i];
                    i++;
                }
                else{
                    H[k] = right1[j];
                    W[k] = right2[j];
                    j++;
                }
            }
            else {
                H[k] = right1[j];
                W[k] = right2[j];
                j++;
            }
            k++;
        }

        while (i < left1.length) {
            H[k] = left1[i];
            W[k] = left2[i];
            i++;
            k++;
        }

        while (j < right1.length) {
            H[k] = right1[j];
            W[k] = right2[j];
            j++;
            k++;
        }
    }
}
