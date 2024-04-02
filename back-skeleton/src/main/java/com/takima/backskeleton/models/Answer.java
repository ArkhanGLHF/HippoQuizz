package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "students")
@Getter
public class Answer {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answerText")
    private String answerText;

    private boolean isCorrect;

    @Column(name = "answerPicture")
    private String answerPicture;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "questionId")

    private Question question;

    private Answer(Builder builder) {
        this.id = builder.id;
        this.answerText = builder.answerText;
        this.isCorrect = builder.isCorrect;
        this.answerPicture = builder.answerPicture;
        this.question = builder.question;
    }
    public Answer() {
    }

    public static class Builder {
        private Long id;
        private String answerText;
        private boolean isCorrect;
        private String answerPicture;
        private Question question;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder answerText(String answerText) {
            this.answerText = answerText;
            return this;
        }
        public Builder isCorrect(boolean isCorrect) {
            this.isCorrect = isCorrect;
            return this;
        }
        public Builder answerPicture(String answerPicture) {
            this.answerPicture = answerPicture;
            return this;
        }
        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        public Answer build() {
            return new Answer(this);
        }
    }
}
