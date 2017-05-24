
/**
 * Created by shailendra.singh on 5/24/17.
 *
 */
class BinarySearch {

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

/**
 * Problem Statement: Given an array of N distinct integers, find floor value of input ‘key’.
 * Say, A = {-1, 2, 3, 5, 6, 8, 9, 10} and key = 7, we should return 6 as outcome.
 */
class FloorUsingBinarySearch {


    int find (int[] a, int key) {

        int left = 0;
        int right = a.length - 1;
        int mid;

        while ( left <= right ) {

            mid = left + right >>> 1;

            if( a[mid] < key) {
                left = mid + 1;
            }
            else if( key < a[mid]) {
                right = mid - 1;
            }
            else {

                // if element is found, and if first element, then no floor exist
                if(mid == 0){
                    return -1;
                }
                // else return just left element
                else {
                    return a[mid - 1];
                }

            }

        }

        // now when the while condition violates, i.e left anr right index surpasses each other
        // three conditions,

        // 1st when right moves, beyond 0
        if(right == -1){
            return -1;
        }

        // 2nd when left moves beyond array length
        else if(left > a.length -1){
            return a[a.length - 1];
        }

        // 3rd , when both left and right, are in middle of the array
        else{

            // when right surpasses left
            if(a[right] < key ){
                return a[right];
            }
            // when left surpasses right
            else {
                return a[left];
            }

        }

    }


}

class BinarySearchDriver {

    public static void main(String[] args) {

        int[] arr = {1,12,23,34,45,56,67,78};

        BinarySearch binarySearch = new BinarySearch();

        FloorUsingBinarySearch floorUsingBinarySearch = new FloorUsingBinarySearch();

        System.out.println("Element found at : " + binarySearch.find(arr, 8));

        System.out.println("Element found at : " + binarySearch.find(arr, 34));

        System.out.println("Floor element: " + floorUsingBinarySearch.find(arr,10));

    }

}
