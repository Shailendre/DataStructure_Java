/**
 * Created by shailendra.singh on 5/26/17.
 *
 * Exponential search: works in sorted array only
 * @idea : first try to find the range in which the key element may be present in logn time
 * , then in the suitable range perform binary search-> logn time
 * overall -> O(logn)
 */
public class ExponentialSearch {

    BinarySearch binarySearch = new BinarySearch();

    int find (int[] a, int key) {

        // if first element is key
        if (a[0] == key) {
            return 0;
        }

        // find the range exponentially
        int i = 1;
        while (i < a.length && a[i] < key) {
            i *= 2;
        }

        // if the range exceeds length of the array, key may be in [i/2, a.length]
        if( i > a.length ){

            return binarySearch.findByRange(a, i/2, a.length, key);

        }
        // else the key may be present in [i/2,i]
        return binarySearch.findByRange(a, i/2, i, key);

    }
}

class ExponentialDriverClass {


    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8};

        ExponentialSearch exponentialSearch = new ExponentialSearch();

        System.out.println("Element found at: " + exponentialSearch.find(a,0));


    }

}
