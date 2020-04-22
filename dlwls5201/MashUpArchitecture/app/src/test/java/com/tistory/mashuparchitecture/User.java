package com.tistory.mashuparchitecture;

import java.util.Date;

public class User {

    private String name; //필수
    private int age; // 필수

    private String address; // 선택
    private String phoneNumber; // 선택
    private Date birthday; // 선택

    User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.birthday = builder.birthday;
    }

    static class Builder {

        private final String name; //필수
        private final int age; // 필수

        private String address; // 선택
        private String phoneNumber; // 선택
        private Date birthday; // 선택

        public User build() {
            return new User(this);
        }

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

    }

}

/*public class User {

    private String name; //필수
    private int age; // 필수

    private String address; // 선택
    private String phoneNumber; // 선택
    private Date birthday; // 선택

    User(String name, int age, String address, String phoneNumber, Date birthday) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

}*/

class Main {

    public static void main(String[] args) {
        User user = new User.Builder("BlackJin", 20)
                .setAddress("Seoul")
                .setPhoneNumber("010-0000-0000")
                .setBirthday(new Date())
                .build();
    }
}
