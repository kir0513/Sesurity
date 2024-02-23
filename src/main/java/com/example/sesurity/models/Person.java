package com.example.sesurity.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "users")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="age")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    @Column(name="email")
    private int email;

    @NotEmpty(message = "LastName should not be empty")
    @Size(min = 2, max = 30, message = "LastName should be between 2 and 30 characters")
    @Column(name="lastName")
    private String lastName;

    @NotEmpty(message = "userName should not be empty")
    @Size(min = 2, max = 30, message = "userName should be between 2 and 30 characters")
    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    public Person(){}

    public Person(String userName, String lastName, int age,  String password ){
        this.age = age;
        this.userName = userName;
        this.lastName = lastName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(int age, int email, String lastName, String userName) {
        this.age = age;
        this.email = email;
        this.lastName = lastName;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", email=" + email +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && getEmail() == person.getEmail() && Objects.equals(getId(), person.getId()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getUserName(), person.getUserName()) && Objects.equals(getPassword(), person.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge(), getEmail(), getLastName(), getUserName(), getPassword());
    }
}
