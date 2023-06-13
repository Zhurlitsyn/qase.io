package dto;

import com.github.javafaker.Faker;

public class SuiteFactory {

    public Suite getRandom() {
        Faker faker = new Faker();
        return Suite.builder()
                .title(faker.hipster().word())
                .description(faker.lorem().characters(5, 255))
                .preconditions(faker.lorem().characters(5, 255))
                .build();
    }

}
