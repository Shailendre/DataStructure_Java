package chap_3;

import java.io.*;
import java.util.Scanner;

/**
 * Created by shailendra.singh on 5/12/17.
 */
class InsertionSort {

    // sorts in non-decreasing order
    public int[] sort(int[] arr) {

        int j, tmp;

        for (int i =1; i<arr.length; i++){

            j = i;

            while(j > 0 && arr[j] < arr[j-1]) {

                tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;

                j--;

            }

        }

        return arr;

    }

}

class DriverClass {

    public static void main(String[] args) {

        try {
            // read from input.txt file, first line repr number of elements
            Scanner inputsc = new Scanner(new File("input.txt"));

            int capacity=0;
            int[] arr = null;

            while(inputsc.hasNextInt()) {

                if(capacity == 0){
                    arr = new int[inputsc.nextInt()];
                }

                arr[capacity++] = inputsc.nextInt();
            }

            // perform insertion sort
            InsertionSort insertionSort = new InsertionSort();

            arr = insertionSort.sort(arr);

            // write the output to txt
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            for(int n : arr){
                bufferedWriter.write(String.valueOf(n));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("No such file as input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
