package persontested;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        try {
            people.add(new Person("Jerry", 33));
            people.add(new Person("Eva", 22));
            people.add(new Person("Jason", 44));
            people.add(new Person("Mary", 55));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        for (Person p : people) {
            System.out.println(p);
        }
        
    }
    
}
