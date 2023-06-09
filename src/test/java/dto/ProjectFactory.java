package dto;

import com.github.javafaker.Faker;

import java.util.Random;

public class ProjectFactory {

    public static String[] listAccessApi = {"all", "none"};
    public static String[] listAccessUI = {"private", "public"};
    public static Random random = new Random();
    public static String choice;

    private static String getRandomFromArray(String[] list) {
        choice = "";
        return choice = list[random.nextInt(list.length)];
    }

    public Project getRandom() {
        Faker faker = new Faker();
        return Project.builder()
                .title(faker.company().buzzword())
                .code(faker.code().gtin8())
                .description(faker.lorem().characters(5, 255))
                .build();
    }

    public static String getRandomAccessUI() {
        String access = getRandomFromArray(listAccessUI);
        return access;
    }

    public static String getRandomAccessApi() {
        String access = getRandomFromArray(listAccessApi);
        return access;
    }
}
