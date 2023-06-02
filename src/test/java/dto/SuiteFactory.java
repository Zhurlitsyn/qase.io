package dto;

import com.github.javafaker.Faker;

public class SuiteFactory {

       public Suite getRandom() {
        Suite suite = new Suite();
        Faker faker = new Faker();

        suite.setTitle(faker.hipster().word());
        suite.setDescription(faker.lorem().characters(5, 255));
        suite.setPrecondition(faker.lorem().characters(5, 255));
        return suite;
    }

}
