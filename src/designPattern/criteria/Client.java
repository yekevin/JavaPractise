package designPattern.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Client {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new MaleCriteria();
        Criteria female = new FemaleCriteria();
        Criteria single = new SingleCriteria();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("males:");
        printPersons(male.meetCriteria(persons));

        System.out.println("females:");
        printPersons(female.meetCriteria(persons));

        System.out.println("single males:");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("single or females:");
        printPersons(singleOrFemale.meetCriteria(persons));

    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person:[Name:" + person.getName() + ",Gender:" + person.getGender() + ",Marital Status:" + person.getMaritalStatus());
        }
    }
}
