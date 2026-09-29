package day2;

public class StackProgram2 {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>(5);

        stack.push("Str10");
        stack.push("Str20");
        stack.push("Str30");
        stack.push("Str40");
        stack.push("Str50");
        stack.push("Str60");

        // System.out.println("Popped element is: " + stack.pop());
        // System.out.println("Is stack empty? " + (stack.isEmpty() ? "Yes" : "No"));
        // System.out.println("Popped element is: " + stack.pop());
        // System.out.println("Is stack empty? " + (stack.isEmpty() ? "Yes" : "No"));
        // System.out.println("Popped element is: " + stack.pop());
        // System.out.println("Is stack empty? " + (stack.isEmpty() ? "Yes" : "No"));
        // System.out.println("Popped element is: " + stack.pop());
        // System.out.println("Is stack empty? " + (stack.isEmpty() ? "Yes" : "No"));
        // System.out.println("Popped element is: " + stack.pop());

        Stack<Integer> intStack = new Stack<>(10);

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.push(40);
        intStack.push(50);
        intStack.push(60);

        System.out.println("Size of integer stack: " + intStack.size());

        // Stack stack = new Stack(5);

        // stack.push(10);
        // stack.push(20);
        // stack.push(30);

        // System.out.println("Top element is: " + stack.peek());
        // System.out.println("Stack size is: " + stack.size());

        // stack.pop();
        // System.out.println("Top element after pop is: " + stack.peek());
        // System.out.println("Stack size after pop is: " + stack.size());

        // while (!stack.isEmpty()) {
        // stack.pop();
        // }

        // stack.pop(); // Attempt to pop from an empty stack

        Stack<BiscuitPack> biscuitStack = new Stack<>(30);

        biscuitStack.push(new BiscuitPack("Good Day", "Britannia"));
        biscuitStack.push(new BiscuitPack("Hide & Seek", "Britannia"));

        biscuitStack.push(new BiscuitPack("Treat", "Britannia"));

        biscuitStack.pop();
        biscuitStack.pop();

    }

}

class Stack<T> {
    private T[] arr;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.capacity = size;
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full. Cannot push " + item);
            return;
        }
        top = top + 1;
        arr[top] = item;
        System.out.println("Pushed: " + item);
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        T item = arr[top];

        arr[top] = null;
        top = top - 1;

        System.out.println("Popped: " + item);
        return item;
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        // return 9 == 10 - 1;
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}

class BiscuitPack {
    private String name;
    private String brand;

    public BiscuitPack(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "BiscuitPack [name=" + name + ", brand=" + brand + "]";
    }

}