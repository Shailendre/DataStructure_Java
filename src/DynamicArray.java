/**
 * Created by shailendra.singh on 5/18/17.
 */
class DynamicArray {

    private int[] array = {1,2};

    private final int incFactor = 2;

    private int currentIndex = array.length - 1;

    private void reAdjustArray() {

        int[] tmp = new int[array.length * incFactor];

        int i = 0;

        for(; i< array.length; i++) {

            tmp[i] = array[i];

        }

        array = tmp;

        currentIndex = i - 1;

    }

     void insertOperation(int el) {

        if(currentIndex == array.length - 1){ // size full

            reAdjustArray();

            insertOperation(el);

        }else {

            array[++currentIndex] = el;

        }

    }

    @Override
    public String toString() {

        System.out.print("[");

        for(int k : array) {
            System.out.print(k + ",");
        }
        System.out.print("]");

        return "";

    }
}

class ArrayDriverClass {

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        // before insert ops
        System.out.println(dynamicArray);

        // insert ops
        dynamicArray.insertOperation(23);

        // after insert ops
        System.out.println(dynamicArray);

    }


}
