/*
    Insertion sort builds a sorted array one element at a time. It
    works well for small arrays and arrays that are already or mostly
    but it is much less efficient for large arrays, compared to more
    advanced algorithms. It is slightly more complex than selection
    sort and performs slightly better, although they have the same
    complexity. It is stable - does not change the order of elements
    with equal keys - and in-place - changes the original array as
    opposed to making a copy, which takes up memory.
    The basic algorithm is:
    * take input one element at a time
    * determine where that element goes in the array
    * insert the element in the array
    Time analysis:
    Worst case = array in reverse sorted order (descending instead of
    ascending, and vice versa)
    Best case = already sorted array
    Average case = array with a random order
    Let's start with just the insert() operation:
    The insert() operation takes a value, compares it to an element, and
    slides the element to the right if it is less than the given value.
    It requires a constant number (c) of lines of code to do this. If we are
    inserting a value that goes at the beginning of a subarray that has k
    elements, then we are executing c lines of code k times. In other words,
    k*c is the upper bound for lines of code when inserting an element into
    a subarray of k elements. This is the worst-case for the insert operation.
    Now let's consider the whole insertionSort() operation:
    The whole insertionSort() operation is a loop which calls insert() on
    a subarray with an increasing size. The worst-case insertion sort is an array
    in reverse sorted order. This means that for every call to insert, the value
    being inserted is less than every element in the subarray to its left (k*c lines).
    The subarray starts out with k=1 elements until k=n-1 so you have
    c*1 + c*2 + c*3 ... c*(n-2) + c*(n-1) = c*(1 + 2 + 3 + ... + n-2 + n-1)
    = c*n*((n-1)/2) = cn^2/2 - cn/2
    For big-O notation, we can ignore the lower order term (cn/2) and we can ignore
    any constants. This leaves us with n^2. So the big-O time complexity of
    insertion sort is O(n^2) in the worst case.
    The best case has O(n) because in the best case, the c lines of code in the
    insert() operation are never run. The line of code to call the insert() operation
    is run with the for loop n times and that is it. So the time for a best case array
    to be sorted is directly proportional to the number of elements in the array.
    The average case of a randomly ordered array will still have O(n^2) complexity.
    This is because, on average, we'd except each element to be less than half the
    elements to its left. Thus, the execution time would only be half the worst case
    running time. But as already mentioned, constant coefficients don't matter.
*/

public class InsertionSort extends Sort {

    public InsertionSort() {}

    public static int[] insert(int[] a, int rightIndex, int value) {
        int i;
        for (i=rightIndex; i>=0 && value < a[i]; i--) {
            a[i+1] = a[i];
        }
        a[i+1] = value;
        return a;
    }

    public int[] sort(int[] a) {
        for (int i=0; i < a.length-1; i++) {
            insert(a, i, a[i+1]);
        }
        return a;
    }

}
