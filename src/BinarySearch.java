
/**
 * Created by shailendra.singh on 5/24/17.
 *
 */
class BinarySearch {

    int find (int[] arr, int key) {

        int low = 0, high = arr.length-1;

        return findByRange(arr, low, high, key);


    }

    int findByRange (int[] a, int low, int high, int key) {

        int mid, midEl;

        while (low <= high ){

            mid = (low + high) >>> 1; // unsigned right shift => operation similar to divide by 2

            midEl = a[mid];

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

/**
 * Problem Statement: Given a sorted array with possible duplicate elements.
 * Find number of occurrences of input ‘key’ in log N time.
 */

class OccurrenceUsingBinarySearch {

    int findExtremeLeftIndex (int[] a , int key ) {

        int low = 0, mid;
        int high = a.length - 1;

        while ( low <= high ) {

            mid = (low + high) >>> 1;

            if ( key > a[mid] ) {

                low = mid + 1;

            } else if ( key < a[mid] ) {

                high = mid - 1;

            } else {

                // if the key is found, and if, mid element is not first element, but left element is also key,
                // then again perform the binary search, keeping low as 0 and high as left element of the found
                if ( mid != 0 && a[mid -1] == key) {

                    low = 0;
                    high = mid - 1;

                }

                // otherwise element found is already extreme left
                else {
                    return mid + 1;
                }

            }

        }


        return -1;
    }


    int findExtremeRightIndex (int[] a, int key) {

        int low = 0, high = a.length -1,mid;

        while (low <= high) {


            mid = (low + high) >>> 1;

            if ( key > a[mid] ) {

                low = mid + 1;

            }
            else if ( key < a[mid] ) {

                high = mid - 1;

            }
            else {

                // if the key is not the last element, and it next element is still the key element
                // perform the search again
                if( mid != a.length -1 && a[mid + 1] == key ) {

                    low = mid + 1;
                    high = a.length -1;

                }
                // return the extreme right index
                else {
                    return mid + 1;
                }


            }

        }

        return -1;

    }

}

/**
 * Problem Statement: Given a sorted array of distinct elements, and the array is rotated at an unknown position.
 * Find minimum element in the array.
 */

class MinimumInRotatedArray {


    int find (int[] a) {


        int low = 0, high = a.length -1, mid, el;

        while (low <= high ) {

            mid = (low + high) >>> 1;

            el = a[mid] ;

            // if already sorted
            if( a[low] <= a[high]) {

                return a[low];

            }
            // if element present in right half
            else if ( a[high] < el ) {

                low = mid + 1;
            }
            // if element present in left half
            else if ( a[low]  > el ) {

                high = mid - 1;
            }
            // if mid element is the minimum
            else  {

                return el;
            }


        }

        return -1;


    }



}

class BinarySearchDriver {

    public static void main(String[] args) {

        int[] arr = {1,12,34,34,34,34,45,56,78,78};

        int[] a = {3,4,5,6,7,8,9,10,1,2};

        BinarySearch binarySearch = new BinarySearch();

        FloorUsingBinarySearch floorUsingBinarySearch = new FloorUsingBinarySearch();

        OccurrenceUsingBinarySearch occurrenceUsingBinarySearch = new OccurrenceUsingBinarySearch();

        MinimumInRotatedArray minimumInRotatedArray = new MinimumInRotatedArray();

        System.out.println("Element found at : " + binarySearch.find(arr, 8));

        System.out.println("Element found at : " + binarySearch.find(arr, 34));

        System.out.println("Floor element: " + floorUsingBinarySearch.find(arr,10));

        System.out.println("Left index at: " + occurrenceUsingBinarySearch.findExtremeLeftIndex(arr, 34));

        System.out.println("Right index at: " + occurrenceUsingBinarySearch.findExtremeRightIndex(arr, 78));

        System.out.println("Minimum element: " + minimumInRotatedArray.find(a));

    }

}
