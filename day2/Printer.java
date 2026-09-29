package day2;

public class Printer {
    <T> void printArraySameLine(T[] arr, String preMsg) {
        System.out.print(preMsg);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    <T> void printArrayNewLine(T[] arr, String preMsg) {
        printArrayNewLine(arr, preMsg, true);
    }

    <T> void printArrayNewLine(T[] arr, String preMsg, boolean addComma) {
        if (null != preMsg) {
            System.out.println(preMsg);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + (addComma ? ", " : ""));
        }
    }
}
