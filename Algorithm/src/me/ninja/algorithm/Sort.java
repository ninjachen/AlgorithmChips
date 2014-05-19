package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-5-12.
 */
public class Sort {

    private static int swapCount = 0;

    public static void main(String[] args) {

        //init test data
//        int [] unsorted = {1,2,3,5,4,2,6,2,1,1};
        Integer[] unsorted = new Integer[15];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * 100 + 0.5);
        }
        System.out.println("Quick sort start !");
        show(unsorted);

        quickSort(unsorted, 0, unsorted.length - 1);

        System.out.println("Quick sort finish.");
        show(unsorted);
    }



    /**
     * let all the left int is less than unsorted[middle]
     * let all the right int is right than unsorted[middle]
     *
     * @param unsorted origin data
     * @param left     left index
     * @param right    right index
     */
    public static void quickSort(Comparable[] unsorted, int left, int right) {
        //error check
        System.out.println("call quick sort,from index " + left + " to " + right);
//
//        int leftPointer = left;
//        int rightPointer = right;
        int leftPointer = partition(unsorted, left, right);
        if (left < leftPointer - 1) {
            quickSort(unsorted, left, leftPointer - 1);
        }
        if (leftPointer < right)
            quickSort(unsorted, leftPointer, right);
    }

    private static int partition(Comparable[] unsorted, int leftPointer, int rightPointer) {
        int middle = (leftPointer + rightPointer) / 2;
        Comparable compareValue = unsorted[middle];
        while (leftPointer < rightPointer) {
            while (unsorted[leftPointer].compareTo(compareValue) < 0) leftPointer++;
            while (unsorted[rightPointer].compareTo(compareValue) > 0) rightPointer--;
            if (leftPointer <= rightPointer) {
                swap(unsorted, leftPointer, rightPointer);
                rightPointer--;
                leftPointer++;
            }
        }
        return leftPointer;
    }

    private static void swap(Comparable[] unsorted, int i, int j) {
        swapCount++;
        Comparable temp = unsorted[i];
        unsorted[i] = unsorted[j];
        unsorted[j] = temp;

        System.out.println("After " + swapCount + "th swap " + i + "," + j + ":");
        show(unsorted);
    }

    private static void show(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("index: " + i + " , value: " + data[i]);
        }

    }


}
