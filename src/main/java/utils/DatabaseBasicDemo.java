import com.github.javafaker.Faker;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DatabaseBasicDemo {
    private static final long SEEDVALUE = 123456L;
    private static final Faker faker = new Faker(new Random(SEEDVALUE));
    private static List<Person> cachedPersons = null;

    public  List<Person> getAllPerson() {
        if( cachedPersons!=null){
            return cachedPersons;
        }
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= 20; ++i) {
            persons.add(new Person()
                    .setFullName(faker.name().fullName())
                    .setGender(faker.options().option("male", "female"))
                    .setEmail(faker.internet().emailAddress())
                    .setAddress(faker.address().country()));
        }
        cachedPersons = persons;
        return persons;

    }

}
