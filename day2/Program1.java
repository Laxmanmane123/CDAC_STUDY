package day2;

public class Program1 {


    class Calculator {

        private int id;

        Calculator(int i) {
            this.id = i;
        }

        void display() {
            System.out.println("Inner class method");
        }

        @Override
        public String toString() {
            return "Calculator Object" + " ID: " + id;
        }
    }

    public static void main(String[] args) {

        Program1 p = new Program1();

        Integer[] intArr = { 1, 2, 3, 4, 5 };
        String[] strArr = { "Hello", "World", "Java" };
        p.<Integer>printArray(intArr);
        p.<String>printArray(strArr);
        
        Calculator[] ca = { p.new Calculator(1), p.new Calculator(2), p.new Calculator(3) };
        p.<Calculator>printArray(ca);

    }

    <T> void printArray(T[] arr) {
        for (T ele : arr) {
            System.out.println(ele);
        }
        
        System.out.println("Type of element: " + arr[0].getClass().getSimpleName());
        System.out.println("Number of elements printed: " + arr.length);
    }


}
