import java.util.Arrays;

/**
 * Created by shailendra.singh on 6/2/17.
 *
 * Implements quick sort recursive
 */
public class QuickSort {


    int partition (Integer[] arr, int low, int high ) {

        int xp = arr[high];

        int j = low - 1, tmp, i;

        for (i = low; i <= high - 1; i++){

            if (xp >= arr[i]) {

                j++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }

        }

        j++;

        tmp = arr[j];
        arr[j] = xp;
        arr[i] = tmp;

        return j;
    }

    void sort(Integer[] arr, int low, int high) {


        if (low < high) {

            int partition = partition(arr, low, high);

            sort(arr, low, partition - 1);
            sort(arr, partition + 1, high);

        }


    }


}

class QuickSortDriverClass {


    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();

        Integer[] a = {13,2,60,12};

        quickSort.sort(a,0,a.length -1);

        Arrays.asList(a).forEach(System.out::println);
    }



}
