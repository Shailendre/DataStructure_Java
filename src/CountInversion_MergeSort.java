import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by shailendra.singh on 6/5/17.
 *
 * Count number of inversions in int array, using merge sort
 * Also merge sort
 */
class CountInversion_MergeSort {

    int count = 0;

    int countInversions (int[] arr, int low, int high) {

        if ( low < high ) {

            int mid = (low + high) >>> 1;

            // inversions in left array
            countInversions(arr, low, mid);

            // inversions in right array
            countInversions(arr, mid + 1, high);

            // + the inversions while merging arrays
            count += mergeInversions(arr, low, high, mid);

        }

        return count;


    }

    // merge part of
    int mergeInversions(int[] arr, int low, int high,int mid ) {

        int count = 0, ll = mid - low + 1, rl = high - mid;


        int[] l = new int[ll];

        int[] r = new int[rl];

        // fill in the left sorted array
        for (int i = 0 ; i < ll; i++){
            l[i] = arr[low + i];
        }

        // fill in the right sorted array
        for (int j = 0; j < rl; j++){
            r[j] = arr[mid + 1 + j];
        }

        // merge left and right subarray
        int i = 0,j = 0, k = low;
        while (i < ll && j < rl){

            if (l[i] > r[j]) {

                arr[k] = r[j++];

                // if left is greater than right element, then total inversions are mid+1-i,
                // i.e every combination of right element with left element
                count += mid + 1 - i;

            }
            else {
                arr[k] = l[i++];
            }

            k++;

        }

        while (i < ll) {
            arr[k++] = l[i++];
        }

        while (j < rl) {
            arr[k++] = r[j++];
        }

        return count;
    }
}

class CountInversion_BruteForce {


    int countInversion( int [] arr, int len ) {

        int count = 0;

        for (int i = 0; i < len; i++ ) {
            for (int j = 0; j < len; j++){
                if ( arr[i] > arr[j] && i < j ){
                    count ++;
                }
            }
        }


        return count;

    }

}

class CountInversion_DriverClass {

    public static void main(String[] args) {

        CountInversion_MergeSort countInversion_mergeSort = new CountInversion_MergeSort();

        CountInversion_BruteForce countInversion_bruteForce = new CountInversion_BruteForce();

        System.out.println("Total number of inversions: " +
                countInversion_mergeSort.countInversions(new int[]{19,20,-6,4,5}, 0, 4));

        System.out.println("Total number of inversions: " + countInversion_bruteForce.countInversion(new int[]{19,20,-6,4,5}, 5));

    }
}
