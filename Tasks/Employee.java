import java.util.Arrays;
import java.util.Date;

public class MyList<T> {
    private Object[] arr;
    private int size;

    public MyList() {
        arr = new Object[100];
        size = 0;
    }

    public void add(T value) {
        if (size == arr.length) resize();
        arr[size++] = value;
    }

    public void removeIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        for (int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null; // Clear the last element
        shrink();
    }

    public void removeValue(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value)) {
                removeIndex(i);
                i--;
            }
        }
    }

    public T get(int idx) {
        if (idx >= 0 && idx < size) return (T) arr[idx];
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

    public static void main(String[] args) {
        MyList<Employee> employees = new MyList<>();

        // Adding employees
        employees.add(new Employee("1", "ABC", 30, new Date()));
        employees.add(new Employee("2", "DEF", 40, new Date()));
        employees.add(new Employee("3", "GHI", 50, new Date()));
        employees.add(new Employee("4", "JKL", 35, new Date()));
        employees.add(new Employee("5", "MNO", 45, new Date()));

        // Print initial size
        System.out.println("Initial size: " + employees.getSize());

        // Retrieving employees
        System.out.println("Employee at index 2: " + employees.get(2).getName());

        // Removing by index
        employees.removeIndex(1);
        System.out.println("\nAfter removing employee at index 1:");
        for (int i = 0; i < employees.getSize(); i++) {
            System.out.println("Employee at index " + i + ": " + employees.get(i).getName());
        }

        // Removing by value
        employees.removeValue(new Employee("3", "GHI", 50, new Date()));
        System.out.println("\nAfter removing employee with ID '3':");
        for (int i = 0; i < employees.getSize(); i++) {
            System.out.println("Employee at index " + i + ": " + employees.get(i).getName());
        }

        // Dynamic resizing
        for (int i = 0; i < 120; i++) {
            employees.add(new Employee(Integer.toString(i + 6), "Employee" + (i + 6), 25 + i, new Date()));
        }
        System.out.println("\nSize after adding 120 more employees: " + employees.getSize());
    }
}

class Employee {
    private String id;
    private String name;
    private int age;
    private Date dateOfJoining;

    public Employee(String id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", dateOfJoining=" + dateOfJoining +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
