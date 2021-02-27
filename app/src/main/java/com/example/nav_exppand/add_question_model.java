package com.example.nav_exppand;

public class add_question_model {

    String name;
    String age;
    String gender;
    String nickname;
    String mobile;
    String email;

    public add_question_model() {

    }

    public add_question_model(String name, String age, String gender, String nickname, String mobile, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nickname = nickname;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
