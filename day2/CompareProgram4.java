package day2;

import java.util.Arrays;
import java.util.Comparator;

public class CompareProgram4 {

    public static void main1(String[] args) {

        Printer p = new Printer();

        Integer[] arr = { 44, 11, 13, 55, 4 };
        p.printArraySameLine(arr, "Before sort : ");
        Arrays.sort(arr);
        p.printArraySameLine(arr, "After sort : ");

        // difference of ascii value of first character of string is used for comparison
        String[] strArr = { "Hello", "World", "Java" };
        p.printArraySameLine(strArr, "Before sort : ");
        Arrays.sort(strArr);
        p.printArraySameLine(strArr, "After sort : ");

    }

    public static void main2(String[] args) {

        Printer p = new Printer();

        Product[] arr = {
                new Product(3, "Pen", 11.33),
                new Product(4, "Pencil", 5.10),
                new Product(1, "Erasor", 6.66),
                new Product(5, "Sharpner", 7.33),
                new Product(2, "Book", 20.00)
        };

        p.printArrayNewLine(arr, "Before sort : ");

        class ProductNameComparator implements Comparator<Product> {
            @Override
            public int compare(Product x, Product y) {
                int diff = x.getName().compareTo(y.getName());
                return diff;
            }

        }
        ProductNameComparator productNameComparator = new ProductNameComparator();

        Arrays.sort(arr, productNameComparator);

        p.printArrayNewLine(arr, "After sort on Name: ");

        class ProductPriceAscComparator implements Comparator<Product> {

            @Override
            public int compare(Product x, Product y) {
                int diff = Double.compare(x.getPrice(), y.getPrice());
                return diff;
            }

        }
        Arrays.sort(arr, new ProductPriceAscComparator());

        p.printArrayNewLine(arr, "After sort on Price: ");

        class ProductPriceDescComparator implements Comparator<Product> {

            @Override
            public int compare(Product x, Product y) {
                int diff = Double.compare(y.getPrice(), x.getPrice());
                return diff;
            }

        }
        Arrays.sort(arr, new ProductPriceDescComparator());
        System.out.println("After sort on Desc Price: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

        class ProductNameDescComparator implements Comparator<Product> {

            @Override
            public int compare(Product x, Product y) {
                int diff = y.getName().compareTo(x.getName());
                return diff;
            }

        }

        Arrays.sort(arr, new ProductNameDescComparator());
        p.printArrayNewLine(arr, "After sort on Desc Name: ");

    }

    public static void main(String[] args) {

        Printer p = new Printer();

        Company[] list = {
                new Company().setId(0).setName("TCS").setEmpCount(1000),
                new Company().setId(1).setName("Accenture").setEmpCount(3000),
                new Company().setId(2).setName("Infosys"),
                new Company().setId(3).setName("Wipro").setEmpCount(1500),
                new Company().setId(4).setName("HCL").setEmpCount(500),
        };

        p.printArrayNewLine(list, "Before sort : ");

        Arrays.sort(list);

        p.printArrayNewLine(list, "After sort : ");

    }

}

class Product {
    private int id;
    private String name;
    private double price;

    public Product() {
        // TODO Auto-generated constructor stub
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20d%-15s%-10.2f", id, name, price);
    }

}


class Company implements Comparable<Company> {

    // boolean isActive;
    private int id;
    private String name;
    private int empCount;

    Company() {
    }

    Company setId(int id) {
        this.id = id;
        return this;
    }

    Company setName(String name) {
        this.name = name;
        return this;
    }

    Company setEmpCount(int empCount) {
        this.empCount = empCount;
        return this;
    }

    // public Company(int id, String name, int empCount) {
    // this.id = id;
    // this.name = name;
    // this.empCount = empCount;
    // }

    @Override
    public int compareTo(Company other) {
        // return this.name.compareTo(other.name);
        return other.empCount - this.empCount;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", empCount=" + empCount + "]";
    }

}