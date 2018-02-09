public class Set {

    private int size = 0;
    private Object[] elements = new Object[2];

    public Set() {}

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object element) {
        return indexOf(element) > -1;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void add(Object element) {
        if (indexOf(element) > -1) { return; }
        if (elements.length == size) {
            Object[] bigger = new Object[size*2];
            System.arraycopy(elements, 0, bigger, 0, size);
            elements = bigger;
        }
        elements[size] = element;
        size++;
    }

    public void remove(Object element) {
        int index = indexOf(element);
        if (index == -1) { return; }
        elements[index] = elements[size-1];
        elements[size-1] = null;
        size--;
    }

}