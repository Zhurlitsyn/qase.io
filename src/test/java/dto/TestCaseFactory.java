package dto;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestCaseFactory {

    public static Random random = new Random();

    private static int getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public TestCase getRandom() {
        Faker faker = new Faker();
        return TestCase.builder()
                .title(faker.funnyName().name())
                .description(faker.lorem().characters(5, 255))
                .preconditions(faker.lorem().characters(5, 255))
                .postconditions(faker.lorem().characters(5, 255))
                .status(getRandomNumber(0, 2))
                .severity(getRandomNumber(1, 6))
                .priority(getRandomNumber(1, 3))
                .layer(getRandomNumber(1, 3))
                .behavior(getRandomNumber(1, 4))
                .type(getRandomNumber(1, 11))
                .is_flaky(getRandomNumber(0, 1))
                .automation(getRandomNumber(0, 2))
                .suite_id(1)
                .build();
    }

}
