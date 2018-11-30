
public class reflection {
    public static void main(String[] args) {
        System.out.println("reflection");

        Person p = new Person("steven");

        System.out.println(p.getClass().getName() + " " + p.getName());

        Class c1 = int.class;
        Class c2 = double[].class;
        System.out.println(c1.getName() + " " + c2.getName());

        try {
            Person p2 = (Person) Class.forName("Person").newInstance();
            p2.setName("johnny");
            System.out.println(p2.getName());
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }
}

class Person {
    private String name;

    Person() {
    }

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}