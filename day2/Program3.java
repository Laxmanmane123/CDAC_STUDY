package day2;

public class Program3 {

    public static void main(String[] args) {

        int[] intArr = new int[100];

        intArr[42] = 10;

        for (int i = 0; i < intArr.length; i++) {
            System.out.println("Element at index " + i + ": " + intArr[i]);
        }

        // int index = -2;
        // // this is custom logic
        // if (index < 0) {
        //     index = intArr.length + index;
        // }
        // System.out.println(intArr[index]);

    }
}