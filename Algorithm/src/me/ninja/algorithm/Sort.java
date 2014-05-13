package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-5-12.
 */
public class Sort {

    private static int swapCount = 0;
    public static void main(String[] args) {

        //init test data
//        int [] unsorted = {1,2,3,5,4,2,6,2,1,1};
        int [] unsorted = new int[10];
        for (int i  = 0; i < unsorted.length; i++){
          unsorted[i] = (int)(Math.random() * 1000);
        }
        System.out.println("交换结束前");
        show(unsorted);

        quickSort1(unsorted, 0 , unsorted.length -1);

        System.out.println("交换结束后");
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
        //error check
        if(left > right) return;
        int middle = (left + right) / 2;
        int compareValue = unsorted[middle];
        int leftPointer = left;
        int rightPointer = right;
        while (leftPointer < rightPointer){
            while (unsorted[leftPointer] < compareValue) {
                leftPointer++;
            }
            while (unsorted[rightPointer] > compareValue) {
                rightPointer--;
            }
            if(leftPointer < rightPointer){
            swap(unsorted, leftPointer, rightPointer);
            rightPointer--;
            leftPointer++;
            }
        }
        if(left < leftPointer -1){
            quickSort(unsorted, left, leftPointer - 1);
        }
        if(leftPointer < right)
            quickSort(unsorted, leftPointer, right);
    }

    public static void quickSort1(int[] unsorted, int left, int right ){
        //error check
//
//        int leftPointer = left;
//        int rightPointer = right;
        int leftPointer = partition(unsorted, left, right);
        if(left < leftPointer -1){
            quickSort(unsorted, left, leftPointer - 1);
        }
        if(leftPointer < right)
            quickSort(unsorted, leftPointer, right);
    }

    public static int partition(int[] unsorted, int leftPointer, int rightPointer){
        int middle = (leftPointer + rightPointer) / 2;
        int compareValue = unsorted[middle];
        while (leftPointer < rightPointer){
            while (unsorted[leftPointer] < compareValue) {
                leftPointer++;
            }
            while (unsorted[rightPointer] > compareValue) {
                rightPointer--;
            }
            if(leftPointer < rightPointer){
                swap(unsorted, leftPointer, rightPointer);
                rightPointer--;
                leftPointer++;
            }
        }
        return leftPointer;
    }

    public static void swap(int[] unsorted, int i, int j){
        swapCount++;
        System.out.println("第" + swapCount + "次交换"+i+","+j+":");
        int temp = unsorted[i];
        unsorted[i] = unsorted[j];
        unsorted[j] = temp;

        show(unsorted);
    }

    public static void show(int[] data){
        for (int i  = 0; i < data.length; i++){
            System.out.println("index: " + i + " , value: " + data[i]);
        }
    }
}
