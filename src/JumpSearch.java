/**
 * Created by shailendra.singh on 5/24/17.
 *
 * Jump search: optimal m steps for jump is n ^.5
 * time taken more than binary search, but less than linear search
 * ONLY on sorted list
 */
public class JumpSearch {


    int find ( int[] arr, int msteps, int key) {

        int prevStepIndex = 0, nextStepIndex = prevStepIndex +  msteps;

        // jump operation, to find the correct range of key
        while ( nextStepIndex < arr.length && key > arr[nextStepIndex] ) {

            prevStepIndex = nextStepIndex;

            nextStepIndex += msteps ;

        }

        // if next step exceeds length, make nextstepindex as arr length, i.e element may be present in last slot
        if( nextStepIndex >= arr.length ) {

            nextStepIndex = arr.length - 1;

        }
            // linear search operation
        for(int i = prevStepIndex; i <= nextStepIndex; i++) {

               if( arr[i] == key )
                   return i + 1;
        }


        return -1;


    }


}
class JumpSearchDriverClass {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        JumpSearch jumpSearch = new JumpSearch();

        System.out.println("Element found at: " + jumpSearch.find( arr, (int) Math.ceil(Math.sqrt(arr.length - 1)), 4 ));

        System.out.println("Element found at: " + jumpSearch.find( arr, (int) Math.ceil(Math.sqrt(arr.length - 1 )), 15 ));


    }

}
