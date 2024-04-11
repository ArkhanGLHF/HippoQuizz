package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

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


    private Question(Builder builder) {
        this.id = builder.id;
        this.questionText = builder.questionText;
        this.questionPicture = builder.questionPicture;
        this.questionAnswer = builder.questionAnswer;
        this.quiz = builder.quiz;
    }

    public Question() {

    }

    public static class Builder {
        private Long id;
        private String questionText;
        private String questionPicture;
        private boolean questionAnswer;
        private Quiz quiz;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder questionText(String questionText) {
            this.questionText = questionText;
            return this;
        }
        public Builder questionPicture(String questionPicture) {
            this.questionPicture = questionPicture;
            return this;
        }

        public Builder questionAnswer(boolean questionAnswer){
            this.questionAnswer = questionAnswer;
            return this;
        }
        public Builder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
