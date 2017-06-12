import java.util.Arrays;

/**
 * Created by shailendra.singh on 6/12/17.
 *
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 *
 */
public class DutchNationalFlag {

    /**
     * @param a unsorted integer array of 0,1,2
     */
    private void sort(Integer[] a) {

        // initial value for first index of 0 , 1 , 2
        int i0 = -1, i1= - 1, i2 = -1;

        for ( int i = 0; i < a.length; i++ ) {

            // replace any 0 with first occurrence  of 1,
            // also initialize the first occurrence of 0
            if (a[i] == 0){

                if (i0 == -1) {

                    i0 = i;

                }

                if (i1 != -1){

                    a[i1++] = 0;
                    a[i] = 1;

                }

            }

            // replace any 1 with first occurrence  of 2,
            // also initialize the first occurrence of 1
            if (a[i] == 1) {


                if (i1 == -1) {

                    i1 = i;
                }

                if (i2 != -1) {

                    a[i2++] = 1;
                    a[i] = 2;

                }
            }

            // initialize first occurrence of 2
            if (a[i] == 2 && i2 == -1) {

                i2 = i;
            }

        }

    }

    public static void main(String[] args) {

        Integer[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        DutchNationalFlag problem = new DutchNationalFlag();

        problem.sort(a);

        Arrays.asList(a).forEach(integer -> System.out.print(integer + " "));


    }

}
