/**
 * Created by shailendra.singh on 5/24/17.
 *
 */
public class BinarySearch {

    int find (int[] arr, int key) {

        int low = 0, high = arr.length-1, mid, midEl;

        while (low <= high ){

            mid = (low + high) >>> 1; // unsigned right shift => operation similar to divide by 2

            midEl = arr[mid];

            if( key < midEl ){
                high = mid - 1;
            } else if ( key > midEl ) {
                low = mid + 1;
            } else {
                return mid + 1;
            }

        }

        return -1;

    }

}
class BinarySearchDriver {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        BinarySearch binarySearch = new BinarySearch();

        System.out.println("Element found at : " + binarySearch.find(arr, 8));

        System.out.println("Element found at : " + binarySearch.find(arr, 34));

    }

}
