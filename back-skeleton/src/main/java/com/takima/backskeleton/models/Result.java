package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/***
    Model representing a result in the system.
 */
@Setter
@Getter
@Entity
@Table(name = "results")

public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "score")
    private int score;
    @Column(name = "date_completed")
    private Date dateCompleted;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    /***
     * Default constructor.
     */
    public Result() {

    }

    /***
     * Private constructor for Builder pattern.
     ***/
    private Result(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.quiz = builder.quiz;
        this.score = builder.score;
        this.dateCompleted = builder.dateCompleted;
    }

    public static class Builder {
        private Long id;
        private User user;
        private Quiz quiz;
        private int score;
        private Date dateCompleted;

        /***
         * Builder pattern method to set the id of the result.
         *
         * @param id : The unique identifier of the result.
         * @return The unique identifier updated.
         */
        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        /***
         * Builder pattern method to set the user of the result.
         *
         * @param user : The user whom belonging the result.
         * @return The user updated.
         */
        public Builder user(User user) {
            this.user = user;
            return this;
        }

        /***
         * Builder pattern method to set the quiz of the result.
         *
         * @param quiz : The quiz whom belonging the result.
         * @return The quiz updated.
         */
        public Builder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        /***
         * Builder pattern method to set the score of the result.
         *
         * @param score : The score of the result.
         * @return The score updated.
         */
        public Builder score(int score) {
            this.score = score;
            return this;
        }

        /***
         * Builder pattern method to set the date completed of the quiz.
         *
         * @param dateCompleted : The date of completion of the quiz.
         * @return The date of completion updated.
         */
        public Builder dateCompleted(Date dateCompleted) {
            this.dateCompleted = dateCompleted;
            return this;
        }

        /***
         * Method to build the Result object from this Builder.
         *
         * @return The constructed Result object.
         ***/
        public Result build() {
            return new Result(this);
        }
    }
}
