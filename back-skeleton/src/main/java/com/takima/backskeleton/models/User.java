package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/***
 * Model representing a user in the system.
 */
@Setter
@Getter
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    /***
     * Default constructor.
     ***/
    public User() {
    }

    /***
     * Private constructor for Builder pattern.
     ***/
    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class Builder {
        private Long id;
        private String username;
        private String email;
        private String password;

        /***
         * Method to set the user's identifier.
         *
         * @param id : The user's identifier.
         * @return The user's identifier updated.
         ***/
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /***
         * Method to set the user's username.
         *
         * @param username : The user's username.
         * @return The user's username updated.
         ***/
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        /***
         * Method to set the user's email.
         *
         * @param email : The user's email.
         * @return The user's email updated.
         ***/
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /***
         * Method to set the user's password.
         *
         * @param password : The user's password.
         * @return The user's password updated.
         ***/
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /***
         * Method to build the User object from this Builder.
         *
         * @return The constructed User object.
         ***/
        public User build() {
            return new User(this);
        }
    }

}

