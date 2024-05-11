package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

/***
 * Model representing a quiz in the system.
 */
@Getter
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    /***
     * Private constructor for Builder pattern.
     ***/
    private Quiz(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
    }

    /***
     * Default constructor.
     */
    public Quiz() {
    }

    public static class Builder {
        private Long id;
        private String title;
        private String description;

        /***
         * Builder pattern method to set the id of the quiz.
         *
         * @param id : The id of the quiz.
         * @return the id of the quiz.
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /***
         * Builder pattern method to set the title of the quiz.
         *
         * @param title : The title of the quiz.
         * @return the title of the quiz.
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /***
         * Builder pattern method to set the description of the quiz.
         *
         * @param description : The description of the quiz.
         * @return the description of the quiz.
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /***
         * Method to build the Quiz object from this Builder.
         *
         * @return The constructed Quiz object.
         ***/
        public Quiz build() {
            return new Quiz(this);
        }
    }
}
