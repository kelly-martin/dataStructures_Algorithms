/*
    Binary search is a super efficient algorithm for finding an item
    in a sorted array, emphasis on sorted. Basically you just divide
    the subarray that could contain the item by 2 until you get to a
    single array index. The subarray that could contain the item is
    based on whether the item is higher/lower than the first/last element
    of the subarray. The first subarray will be the entire array with the
    first and last elements being the elements at the 0th and (n-1)th indexes.
    The first guess would be the (n/2)th index element. If the requested
    item is greater than that, the next subarray to check is from index
    n/2 to n-1. If it is smaller, the next subarray to check if from index
    0 to n/2. If it is equal, return of course. Continue this till the element
    that is guesses equals the requested item.
    In the worst case, the number of guesses that the binary search function
    will make is equal to the number of times we can repeatedly divide by 2,
    starting at n until we get 1. This is the same as the base-2 logarithm of n.
    (Brief side note on logarithms: the base of a logarithm function of n
    indicates the number that n would need to be repeatedly divided by to get 1)
    Logarithms grow very slowly and are the inverse of exponentials, which grow
    rapidly. Even compared to linear functions, logarithms grow very slowly.
    This is why binary search is much better than linear search.
 */

import static java.lang.Math.round;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("The sorted array: " + java.util.Arrays.toString(arr));
        int intToSearch = 1;
        int index = search(arr, intToSearch);
        if (index < 0) { System.out.println(intToSearch + " is not in the array."); }
        else { System.out.println("The index of " + intToSearch
                    + " in the array is " + index + "."); }
    }

    public static int search(int[] a, int target) {
        int min = 0;
        int max = a.length-1;
        int guess;
        while (max >= min) {
            guess = round((max+min)/2);
            if (a[guess] > target) { max = guess - 1; }
            else if (a[guess] < target) { min = guess + 1; }
            else { return guess; }
        }
        return -1;
    }
}
