package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-5-12.
 */
public class Sort {

    private static int swapCount = 0;

    public static void main(String[] args) {

        //init test data
//        Integer [] data = {1,22,33,44,47,54,67,223,1111};
        Integer target = 67;
        Integer[] data = new Integer[55];
        for (int i = 0; i < data.length; i++) {
            if(i ==0)
                data[i] = 1;
            else
                data[i] = data[i-1] + (int) (Math.random() * 100 + 0.5);
            if(i == 43)
                target = data[43];
        }

//        System.out.println("Quick sort start !");
//        System.out.println();
//        show(data);
//
//        quickSort(data, 0, data.length - 1);
//        System.out.println();
//        System.out.println("Quick sort finish.");
        show(data);

        System.out.println();
        System.out.println("Search start");
        System.out.println("target index is " + binarySearch(data, 0, data.length -1, target));

    }


    public static void mergeSort(Comparable[] unsorted, int left, int right) {
        int middle = (left + right) / 2;
        mergeSort(unsorted, left, middle);
        mergeSort(unsorted, middle + 1, right);
    }



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

    /**
     * search target's index from sorted data
     * if miss,return -1;
     * @param sorted
     * @param target
     * @return
     */
    private static int binarySearch(Comparable[] sorted,int start,int end,Comparable target){
        if (start > end)
            return -1;

        int middle = (start + end)/2;
        if(sorted[middle].compareTo(target) == 0)
            return middle;
        else if(sorted[middle].compareTo(target) > 0)
            return binarySearch(sorted, start, middle - 1, target);
        else if(sorted[middle].compareTo(target) < 0)
            return binarySearch(sorted, middle + 1, end, target);

        return -1;
    }

}
