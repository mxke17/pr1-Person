import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * averageAgePerGender method tests cases
 *
 * 1. Parameter null -> NullListException
 * 2. Empty list of people -> {0,0}
 * 3. No males in list -> {0,average}
 * 4. No females in list -> {average,0}
 * 5. Only one male and one female -> {MaleAge,FemaleAge}
 * 6. Normal case, some males and some females -> {average,average}
 * 7. Impossibly ages(more than 120, less than 0 or null values) are discarded
 *      -> {average,average} without unusual values
 *
 * getters methods tests cases
 *
 * 8. getName -> Person name
 * 9. getAge -> Person age
 * 10. getGender -> Person gender
 */

public class PersonTest {

    List<Person> persons;
    // MALES EXAMPLES
    Person male1 = new Person("name1", 30, "m");
    Person male2 = new Person("name2", 31, "M");
    Person male3 = new Person("name3", 32, "m");
    Person male4 = new Person("name4", 33, "M");
    Person male5 = new Person("name5", 200, "m"); // Unusual value

    //FEMALE EXAMPLES
    Person female1 = new Person("name1", 30, "f");
    Person female2 = new Person("name2", 31, "F");
    Person female3 = new Person("name3", 32, "f");
    Person female4 = new Person("name4", 33, "F");
    Person female5 = new Person("name5", -1, "f");





    @BeforeEach
    void setUp(){
        persons = new ArrayList<Person>();
    }

    @AfterEach
    void shutDown(){
        persons = null;
    }

    @Test // 1
    void testPersonParameterIsNullGivesAnException(){
        assertThrows(NullListException.class, () -> Person.averageAgePerGender(null));
    }

    @Test // 2
    void testPersonEmptyListOfPersonsIs0_0(){
        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {0,0};

        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test // 3
    void testPersonNoMalesInListIs0_Average(){
        persons.add(female1);
        persons.add(female2);
        persons.add(female3);
        persons.add(female4);

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {0,31.5};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test // 4
    void testPersonNoFemalesInListIsAverage_0(){
        persons.add(male1);
        persons.add(male2);
        persons.add(male3);
        persons.add(male4);

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {31.5,0};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test // 5
    void testPersonOnlyOneMaleAndOneFemaleIsMaleAge_FemaleAge(){
        persons.add(male1);
        persons.add(female1);

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {30,30};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test // 6
    void testPersonNormalCaseIsAverage_Average(){
        persons.add(female1);
        persons.add(female2);
        persons.add(female3);
        persons.add(female4);

        persons.add(male1);
        persons.add(male2);
        persons.add(male3);
        persons.add(male4);

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {31.5,31.5};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test // 7
    void testPersonUnusualValuesAreDiscardedIsAverage_Average(){
        persons.add(female1);
        persons.add(female2);
        persons.add(female3);
        persons.add(female4);
        persons.add(female5); // Unusual value

        persons.add(male1);
        persons.add(male2);
        persons.add(male3);
        persons.add(male4);
        persons.add(male5); // Unusual value

        double[] obtainedValue = Person.averageAgePerGender(persons);
        double[] expedtedValue = {31.5,31.5};
        assertTrue(Arrays.equals(obtainedValue,expedtedValue));
    }

    @Test // 8
    void testPersonGetNameIsName(){
        String obtanedValue = male1.getName();
        String expedtedValue = "name1";
        assertEquals(obtanedValue,expedtedValue);
    }

    @Test // 9
    void testPersonGetAgeIsAge(){
        int obtanedValue = male1.getAge();
        int expedtedValue = 30;
        assertEquals(obtanedValue,expedtedValue);
    }

    @Test // 10
    void testPersonGetGenderIsGender(){
        String obtanedValue = male1.getGender();
        String expedtedValue = "m";
        assertEquals(obtanedValue,expedtedValue);
    }

}
