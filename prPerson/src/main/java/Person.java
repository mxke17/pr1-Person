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

    public static double[] averageAgePerGender(List<Person> persons){

        // If parameter persons is null => return an exception
        if (persons == null) {
            throw new NullListException("Error, null as persons");
        }

        // If list persons is empty => average is 0 in both genders {0,0}
        if (persons.isEmpty()){
            return new double[]{0, 0};
        }

        // Lists of male ages and female ages
        List<Integer> maleAges = new ArrayList<Integer>();
        List<Integer> femaleAges = new ArrayList<Integer>();

        // Checks all the list of persons and classify the ages, also checks if there are unusual values
        for (Person p:persons){
            if (p.gender.contains("f") || p.gender.contains("F")){
                if (p.age <= 120 && p.age >= 0){
                    femaleAges.add(p.age);
                }
            } else {
                if (p.age <= 120 && p.age >= 0){
                    maleAges.add(p.age);
                }
            }
        }

        // Average of genders
        double averageMale = 0;
        if (!maleAges.isEmpty()){ // If it is empty return 0
            averageMale = average(maleAges);
        }

        double averageFemale = 0;
        if (!femaleAges.isEmpty()){
            averageFemale = average(femaleAges);
        }


        return new double[]{averageMale, averageFemale};
    }

    // Calculate average of a list of ages (integer)
    private static double average(List<Integer> ages){
        float sum = 0;
        double average;

        for (Integer age:ages){
            sum += age;
        }

        average = sum/ages.size();

        return average;
    }

}
