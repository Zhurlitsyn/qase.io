package dto;

import com.github.javafaker.Faker;

import java.util.Random;

public class CaseFactoryApi {

    public static Random random = new Random();


    private static Integer getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public CaseApi getRandom() {
        CaseApi caseOne = new CaseApi();
        Faker faker = new Faker();

        caseOne.setTitle(faker.funnyName().name());
        caseOne.setDescription(faker.lorem().characters(5, 255));
        caseOne.setPreconditions(faker.lorem().characters(5, 255));
        caseOne.setPostconditions(faker.lorem().characters(5, 255));
        caseOne.setStatus(getRandomNumber(0, 2));
        caseOne.setSeverity(getRandomNumber(1, 6));
        caseOne.setPriority(getRandomNumber(1, 3));
        caseOne.setLayer(getRandomNumber(1, 3));
        caseOne.setBehavior(getRandomNumber(1, 4));
        caseOne.setType(getRandomNumber(1, 11));
        caseOne.setIs_flaky(getRandomNumber(0, 1));
        caseOne.setAutomation(getRandomNumber(0, 2));
        caseOne.setSuite_id(1);

        return caseOne;
    }

}
