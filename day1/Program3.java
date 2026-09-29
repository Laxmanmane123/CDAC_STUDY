package day1;

public class Program3 {

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30, "ID123");
        System.out.println(p1);

        Person p2 = (Person) p1.clone(); // Create a clone of p1
        System.out.println(p2);

        System.out.println("Are p1 and p2 the same object? " + (p1 == p2));

        System.out.println("Do p1 and p2 have the same identity? " + (p1.getIdenty() == p2.getIdenty()));

        // shalow copy default
        // ref1 {
        // a
        // b
        // c
        // }
        // ref2 clone {
        // x:a
        // y:b
        // z:c
        // }

    }

}

class Person implements Cloneable {
    private String name;
    private int age;
    private Identy identy;

    class Identy {
        private String id;

        Identy(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Identy{ \"id\": \"" + this.id + "\" }";
        }
    }

    Person() {
    }

    Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.identy = new Identy(id);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Identy getIdenty() {
        return this.identy;
    }

    public void setIdenty(Identy identy) {
        this.identy = identy;
    }

    // Shallow copy clone method
    // @Override
    // public Person clone() {
    // try {

    // Person cloned = (Person) super.clone();

    // cloned.setName(this.name);
    // cloned.setAge(this.age);
    // cloned.setIdenty(identy);

    // return cloned;

    // } catch (CloneNotSupportedException e) {
    // throw new AssertionError("Clone not supported", e);
    // }
    // }

    // Deep copy clone method
    // eg. Profile edit on background page and editing popup
    @Override
    public Person clone() {
        try {
            Person cloned = (Person) super.clone();
            cloned.setName(new String(this.name));
            cloned.setAge(this.age);
            cloned.setIdenty(new Identy(this.identy.id)); // Create a new Identy object for deep copy
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Person{ \"name\": \"" + this.name + "\", \"age\": " + this.age + ", \"identy\": " + this.identy + " }";
    }
}
