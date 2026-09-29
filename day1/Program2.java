package day1;

public class Program2 {

    public static void main(String[] args) {

        // System.out.println(1 == 1); // compares primitive values, returns true
        // System.out.println("Hello" == "Hello");

        // Company c1 = new Company(1, "XYZ Inc", 500000);
        // // Company c2 = new Company(1, "XYZ Inc", 500000);

        // Company c2 = new Company(2, "ABC Corp", 1000000);

        // System.out.println(c1);
        // System.out.println(c2);

        // System.out.println(c1 == c2); // false, because c1 and c2 are different
        // // objects in memory
        // System.out.println(c1.equals(c1)); // true, because c1 and c1 are the same object in memory

        // // check equality of two objects based on their content using equals() method

        // System.out.println(c1.equals(c2));
        // System.out.println(c1.equals(Integer.valueOf(1)));


        Company c3 = new Company(2412, "DEF Ltd", 7987888);

        System.out.println(c3.getClass());
        


    }

}

class Company {

    private int id;
    private String name;
    private int revenue;

    Company() {
    }

    Company(int id, String name, int revenue) {
        this.id = id;
        this.name = name;
        this.revenue = revenue;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Company Name: " + this.name + ", Revenue: $" + this.revenue;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (!( obj instanceof Company)) {
            return false;
        }
        
        Company other = (Company) obj;
     
        // return this.id == other.id;
        // return this.name == other.name;

        if (this.id == other.id && this.name.equals(other.name)) {
            return true;
        }
        return false;
    }

}