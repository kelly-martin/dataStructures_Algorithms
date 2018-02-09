public class Stack {

    private int size = 0;
    private Object[] elements = new Object[2];

    public Stack() {}

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // add element to top of stack, increasing size of stack as necessary
    public void push(Object element) {
        if (elements.length == size) {
            Object[] bigger = new Object[size*2];
            System.arraycopy(elements, 0, bigger, 0, size);
            elements = bigger;
        }
        elements[size] = element;
        size++;
    }

    // return, but don't remove, element at top of stack
    public Object peek() {
        if (empty()) { return null; }
        return elements[size-1];
    }

    // remove and return element at top of stack
    public Object pop() {
        if (empty()) { return null; }
        Object ret = elements[size-1];
        elements[size-1] = null;
        size--;
        return ret;
    }
}
