import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Person Miguel = new Person("Miguel",21,"male");
        Person Lucia = new Person("Lucia",21,"F");
        Person Paula = new Person("Paula",20,"female");
        // Expected Male=21, Female=20.5
        List<Person> persons = new ArrayList<Person>();
        persons.add(Miguel);
        persons.add(Lucia);
        persons.add(Paula);

        double[] test = Person.averageAgePerGender(persons);
        System.out.println(test[0]);
        System.out.println(test[1]);




    }
}
