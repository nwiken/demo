package se.home.model.service;


public class PersonDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Integer age;



    private PersonDto(Long id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if(age < 1) {
            throw new IllegalArgumentException("Age must be > 0");
        }
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(id, firstName, lastName, age);
        }
    }
}
