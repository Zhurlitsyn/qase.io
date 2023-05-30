package dto;

import com.github.javafaker.Faker;

public class ProjectFactory {

    public Project getRandom() {
        Project project = new Project();
        Faker faker = new Faker();

        project.setTitle(faker.company().buzzword());
        project.setCode(faker.code().gtin8());
        project.setDescription(faker.lorem().characters(5,30));
        return project;
    }
}
