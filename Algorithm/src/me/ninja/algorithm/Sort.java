package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-5-12.
 */
public class Sort {

    public static void main(String[] args) {

        //init test data
        int [] unsorted = new int[100];
        for (int i  = 0; i < unsorted.length; i++){
          unsorted[i] = (int)(Math.random() * 1000);
        }

        quickSort(unsorted, 0 , unsorted.length -1);

        show(unsorted);
    }


    /**
     * let all the left int is less than unsorted[middle]
     * let all the right int is right than unsorted[middle]
     * @param unsorted origin data
     * @param left left index
     * @param right right index
     */
    public static void quickSort(int[] unsorted, int left, int right ){
        int middle = (left + right) / 2;
        int compareValue = unsorted[middle];
        //error check
        if(left > right) return;
        int leftPointer = left;
        int rightPointer = right;
        while (leftPointer < rightPointer){
            while (unsorted[leftPointer++] < compareValue) {
                if(leftPointer == right) break;
            }
            while (unsorted[rightPointer--] > compareValue) {
                if(rightPointer == left) break;
            }
            if(leftPointer < rightPointer){
            swap(unsorted, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
            }
        }
        quickSort(unsorted, left, middle - 1);
        quickSort(unsorted, middle + 1, right);
    }

    public static void swap(int[] unsorted, int i, int j){
        int temp = unsorted[i];
        unsorted[i] = unsorted[j];
        unsorted[j] = temp;
    }

    public static void show(int[] data){
        for (int i  = 0; i < data.length; i++){
            System.out.println("index: " + i + " , value: " + data[i]);
        }
    }
}
