/*
 * This implementation supports:
 * 1. Adding a new valu.
 * 2. Removing elements by index.
 * 3. Removing elements by value.
 * 4. Retrieving a value by index.
 * 5. Automatic resizing.
 */



import java.util.Arrays;

public class MyList {
    private int[] arr;
    private int size;

    public MyList() {
        arr = new int[100];
        size = 0;
    }
    
    public void add(int value) {
        if (size == arr.length) resize();
        arr[size++] = value;
    }

    public void removeIndex(int idx) {
        if (idx<0 || idx>=size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        for (int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        shrink();
    }

    public void removeValue(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                removeIndex(i);
                i--; 
            }
        }
    }
    
    public int get(int idx) {
        if (idx >= 0 && idx < size) {
            return arr[idx];
        }
        throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
    }
    
    private void resize() {
        arr = Arrays.copyOf(arr, arr.length * 2);
    }
    
    private void shrink() {
        if (size > 100 && size <= arr.length / 4) {
            arr = Arrays.copyOf(arr, arr.length / 2);
        }
    }
    
    public int getSize() {
        return size;
    }
// EXAMPLE IMPLEMENTATION
    public static void main(String[] args) {
        MyList list = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        // Size of the list
        System.out.println(myList.getSize()); // Output: 3
      
        // Retrieving values by Index
        System.out.println(myList.get(1)); // Output: 20
      
        // Removing by value
        myList.removeValue(3);
        System.out.println("Size after removing value 30: " + myList.getSize());
      
        // Deleting by index
        myList.removeAt(1);
        System.out.println(myList.get(1)); // Output: 30
      
        // Adding more 
        for (int i = 0; i < 200; i++) {
            myList.add(i);
        }
        // Size after adding values
        System.out.println(myList.getSize());
        
    }
}
