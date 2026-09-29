package day1;

class Elephant {

    private String name;
    private int age;

    Elephant() {
    }

    Elephant(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "My name is " + this.name + " and I am " + this.age + " years old.";
    }
}
