package persontested;

import java.util.Date;

public class Person {

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    
    private String name;
    private int age;
    // Homework: 1) encapsulate fields, 2) write setters, 3) write unit tests for each setter
    String postalCode; // "7A7 A7A"
    double weightKg; // 0-300 (both inclusive)
    Date dateOfBirth; // valid date YYYY-MM-DD from 1900 to 2099 year

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Name too short");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
    
}
