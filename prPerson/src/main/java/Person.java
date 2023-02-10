import java.util.ArrayList;
import java.util.List;

/**
  * Class representing a person with a name, age and gender
  *
  * @autor Miguel Jurado Vazquez
  */

public class Person {
    private final String name;
    private final int age;
    private final String gender;


    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name the  name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */

    public double[] averageAgePerGender(List<Person> persons){

        // If list persons is empty => average is 0 in both genders
        if (persons.isEmpty()){
            return new double[]{0, 0};
        }

        List<Integer> maleAges = new ArrayList<Integer>();
        List<Integer> femaleAges = new ArrayList<Integer>();

        // Check all the list of persons and classify the ages
        for (Person p:persons){
            if (p.gender.compareTo("female") == 0){
                femaleAges.add(p.age);
            } else {
                maleAges.add(p.age);
            }
        }

        // Average of genders
        double averageMale = average(maleAges);
        double averageFemale = average(femaleAges);

        return new double[]{averageMale, averageFemale};
    }

    // Calculate average of a list of ages (integer)
    private double average(List<Integer> ages){
        int sum = 0;
        double average;

        for (Integer age:ages){
            sum += age;
        }

        average = sum/ages.size();

        return average;
    }

}
