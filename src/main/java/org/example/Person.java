package org.example;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int account;

    public Person(String name, int age, int account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public void addBalance(double amount) {
        this.account += amount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public int compareTo(Person person) {
        return (this.getAge() > person.getAge()) ? 1:
                (this.getAge() == person.getAge()) ? 0 :
                -1;
    }
}
