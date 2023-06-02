package dto;

import com.github.javafaker.Faker;

import java.util.Random;

public class ProjectFactory {

    public static String[] listAccessApi = {"all", "none"};
    public static String[] listAccessUI = {"private", "public"};
    public static Random random = new Random();
    public static String choice;

    static String getRandomStringData(String[] list) {
        choice = "";
        return choice = list[random.nextInt(list.length)];
    }

    public Project getRandomUI() {
        Project project = new Project();
        Faker faker = new Faker();

        project.setTitle(faker.company().buzzword());
        project.setCode(faker.code().gtin8());
        project.setDescription(faker.lorem().characters(5, 255));
        project.setAccess(getRandomStringData(listAccessUI));
        return project;
    }

    public Project getRandomApi() {
        Project project = new Project();
        Faker faker = new Faker();

        project.setTitle(faker.company().buzzword());
        project.setCode(faker.code().gtin8());
        project.setDescription(faker.lorem().characters(5, 255));
        project.setAccess(getRandomStringData(listAccessApi));
        return project;
    }
}
