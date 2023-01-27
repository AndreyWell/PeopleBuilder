package ru.netology;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;
    private String groupAge;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.groupAge = getGroupAge(age);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private boolean hasAge() {
        if (age != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasAddress() {
        if (!address.equals(null)) {
            return true;
        }
        return false;
    }

    public int happyBirthday() {
        if (hasAge()) {
            return age += 1;
        }
        return this.age;
    }

    private String getGroupAge(int age) {
        if (hasAge()) {
            if (age < 18) {
                return "young";
            } else if (age > 18 && age < 70) {
                return "adult";
            } else {
                return "old";
            }
        }
        return "Возраст не определен";
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.getSurname())
                .setAge(1)
                .setAddress(this.getAddress());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", [" + groupAge + "]" +
                '}';
    }
}
