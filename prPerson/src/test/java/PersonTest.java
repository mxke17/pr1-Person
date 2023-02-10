import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests cases
 * 1. Empty list of people
 * 2. No males in list
 * 3. No females in list
 * 4. Only one male and one female
 * 5. Normal case, some males and some females
 * 6. Check that impossibly ages(more than 120, less than 0 or null values) are discarted
 */

public class PersonTest {

    List<Person> persons;


    @BeforeEach
    void setUp(){
        persons = new ArrayList<Person>();
    }

    @AfterEach
    void shutDown(){
        persons = null;
    }

    @Test
    void testPersonEmptyListOfPersons(){
        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {0,0};

        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test
    void testPersonNoMalesInList(){
        Person female1 = new Person("name1", 30, "f");
        persons.add(female1);
        Person female2 = new Person("name2", 31, "F");
        persons.add(female2);
        Person female3 = new Person("name3", 32, "f");
        persons.add(female3);
        Person female4 = new Person("name4", 33, "F");
        persons.add(female4);

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {0,31.5};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test
    void testPersonNoFemalesInList(){
        Person male1 = new Person("name1", 30, "m");
        persons.add(male1);
        Person male2 = new Person("name2", 31, "M");
        persons.add(male2);
        Person male3 = new Person("name3", 32, "m");
        persons.add(male3);
        Person male4 = new Person("name4", 33, "M");
        persons.add(male4);

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {31.5,0};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

}
