package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

/***
 * Model representing a question in the system.
 * */
@Entity
@Table(name = "questions")
@Getter

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "question_picture")
    private String questionPicture;
    private boolean questionAnswer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    /***
     * Private constructor for Builder pattern.
     ***/
    private Question(Builder builder) {
        this.id = builder.id;
        this.questionText = builder.questionText;
        this.questionPicture = builder.questionPicture;
        this.questionAnswer = builder.questionAnswer;
        this.quiz = builder.quiz;
    }

    /***
     * Default constructor.
     */
    public Question() {
    }

    public static class Builder {
        private Long id;
        private String questionText;
        private String questionPicture;
        private boolean questionAnswer;
        private Quiz quiz;

        /***
         * Builder pattern method to set the id of the question.
         *
         * @param id : The id of the question.
         * @return the id of the question.
         */
        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        /***
         * Builder pattern method to set the question text.
         *
         * @param questionText : The text of the question.
         * @return the text of the question.
         */
        public Builder questionText(String questionText) {
            this.questionText = questionText;
            return this;
        }

        /***
         * Builder pattern method to set the question picture.
         *
         * @param questionPicture : The picture of the question.
         * @return the picture of the question.
         */
        public Builder questionPicture(String questionPicture) {
            this.questionPicture = questionPicture;
            return this;
        }

        /***
         * Builder pattern method to set the question answer.
         *
         * @param questionAnswer : The answer of the question.
         * @return the answer of the question.
         */
        public Builder questionAnswer(boolean questionAnswer){
            this.questionAnswer = questionAnswer;
            return this;
        }

        /***
         * Builder pattern method to set the quiz of the question.
         *
         * @param quiz : The quiz whom belonging the question.
         * @return The quiz updated.
         */
        public Builder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        /***
         * Method to build the question.
         *
         * @return The question built.
         */
        public Question build() {
            return new Question(this);
        }
    }
}
