package rt.ex3.domain;

import java.time.LocalDate;

public class User {
    private static int userCount = 1;

    private final int id;
    private String name;
    private String familyName;
    private LocalDate birthDate;
    private int currentAge;
    private long phoneNumber;


    public User() {
        this.id = userCount++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int year, int month, int day) {
        this.birthDate = LocalDate.of(year, month, day);
        this.currentAge = LocalDate.now().getYear() - year;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCurrentAge() {
        return currentAge;
    }
}
