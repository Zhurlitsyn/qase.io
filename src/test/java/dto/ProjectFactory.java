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
        Project project = new Project();
        Faker faker = new Faker();

        project.setTitle(faker.company().buzzword());
        project.setCode(faker.code().gtin8());
        project.setDescription(faker.lorem().characters(5, 255));
        return project;
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
