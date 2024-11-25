/*
 This implementation supports:
 - Implement a dynamic, resizable list that supports generic types.
 - Allow basic list operations such as:
     1. Adding a new element.
     2. Deleting an element by its index.
     3. Deleting an element by its value.
     4. Retrieving an element by index.
 - Support dynamic resizing: grow the array when full and shrink it when underutilized.
 - Ensure compatibility with various types, including Integer, String, and custom classes.
 */
import java.util.Arrays;

public class MyList<T> {
    private Object[] arr; 
    private int size;

    public MyList() {
        arr = new Object[100];
        size = 0;
    }
    
    public void add(T value) {
        if(size == arr.length) resize();
        arr[size++] = value;
    }

    public void removeIndex(int idx) {
        if(idx<0 || idx>=size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        for(int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        shrink();
    }

    public void removeValue(T value) {
        for(int i = 0; i < size; i++) {
            if(arr[i].equals(value)) {
                removeIndex(i);
                i--; 
            }
        }
    }
    
    public T get(int idx) {
        if(idx >= 0 && idx < size) return (T) arr[idx];
        throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
    }
    
    private void resize() {
        arr = Arrays.copyOf(arr,arr.length * 2);
    }
    
    private void shrink() {
        if(size>100 && size<=arr.length / 4) {
            arr = Arrays.copyOf(arr,arr.length / 2);
        }
    }
    
    public int getSize() {
        return size;
    }

    
    }
}
