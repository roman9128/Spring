package rt.lesson4hw.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {
    private static int userCount = 1;

    private final int id;
    private String name;
    private String familyName;
    private int birthYear, birthMonth, birthDay;
    private LocalDate birthDate;
    private int currentAge;
    private long phoneNumber;


    public User() {
        this.id = userCount++;
        birthYear = 1900;
        birthMonth = 1;
        birthDay = 1;
        setBirthDate();
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        setBirthDate();
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
        setBirthDate();
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
        setBirthDate();
    }

    public void setBirthDate() {
        this.birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        this.currentAge = Long.valueOf(birthDate.until(LocalDate.now(), ChronoUnit.YEARS)).intValue();
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
