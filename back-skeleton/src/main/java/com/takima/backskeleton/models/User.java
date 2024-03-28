package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;

    private String password;

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
    }


    public User() {
    }

    public User(String lastName, String lastname, String password) {
        this.firstName = lastName;
        this.lastName = lastname;
        this.password = password;
    }

    public User(Long id, String name, String lastname, String password) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastname;
        this.password = password;
    }


    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String password;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}
