public class CompareSorts {

    public static void main(String[] args) {

        int[] arr = {88, 76, 55, 45, 42, 40, 30, 28, 26, 25, 17, 15, 11, 9, 8, 7, 3, 2, 0, -9, -11, -17, -20, -22};
        // sorted = {-22, -20, -17, -11, -9, 0, 2, 3, 7, 8, 9, 11, 15, 17, 25, 26, 28, 30, 40, 42, 45, 55, 76, 88}
        System.out.println("Initial array: \n" + java.util.Arrays.toString(arr) + "\n");

        System.out.println("Selection Sort");
        runSort(arr, new SelectionSort());
        System.out.println("Insertion Sort");
        runSort(arr, new InsertionSort());

        System.out.println("Conclusion: Given the same worst-case array of integers, insertionSort() " +
                "takes less time than \nselectionSort() to produce the same sorted array.");

    }

    public static void runSort(int[] a, Sort sort) {
        long startTime = System.nanoTime();
        int[] sortedArr = sort.sort(a);
        long endTime = System.nanoTime();
        System.out.println("Array after sort(): \n" +
                java.util.Arrays.toString(sortedArr));
        System.out.println("Time to execute sort(): "
                + (endTime-startTime) + " nanoseconds\n");
    }

}
