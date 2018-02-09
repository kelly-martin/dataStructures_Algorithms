/*
    Given an unsorted array, selection sort finds the minimum value, swaps it
    with the value in the first position, and repeats this for the remainder
    of the array. It is the simplest sort algorithm to implement but also the
    most inefficient. It has O(n^2) complexity like insertion sort, but tends
    to perform slightly worse than insertion sort.
    Let's consider the run time for worst case (reverse sorted array) selection sort:
    The run time consists of (1) the calls to indexOfMinimum, (2) the calls to swap,
    and (3) the rest of the loop in selectionSort.
    Let's deal with (2) first: There will be n calls to swap since it is called in
    every iteration of the for loop, which runs a total of n times. There is a
    constant number of lines of code to be run in swap so the run time for the calls
    to swap is just O(n).
    Now let's deal with (3): The selectionSort loop is just testing and incrementing
    the loop variable and making the calls to indexOfMinimum and swap. All of that
    takes constant time for each of the n iterations of the loop so that is also
    just O(n) time.
    Now let's deal with (1): The indexOfMinimum() function consists of a for loop
    which executes a constant number of lines of code. The first call to it runs the
    for loop n times, then n-1, then n-2 and so on, producing an arithmetic series
    that equals (n^2)/2 + n/2, which equates to O(n^2) complexity.
    Adding up the three parts results in O(n^2) + O(n) + O(n) which equates to O(n^2)
    complexity since we ignore the lower order components.
    This is the complexity in all cases since the loop in indexOfMinimum will always
    run essentially n^2 iterations.
*/

public class SelectionSort extends Sort {

    public SelectionSort() {}

    public static void swap(int[] a, int firstIndex, int indexOfMin) {
        int temp = a[firstIndex];
        a[firstIndex] = a[indexOfMin];
        a[indexOfMin] = temp;
    }

    public static int indexOfMinimum(int[] a, int startIndex) {
        int minValue = a[startIndex];
        int minIndex = startIndex;

        for (int i = minIndex + 1; i < a.length; i++) {
            if (a[i] < minValue) {
                minIndex = i;
                minValue = a[i];
            }
        }
        return minIndex;
    }

    public int[] sort(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            min = indexOfMinimum(a, i);
            swap(a, i, min);
        }
        return a;
    }
}
