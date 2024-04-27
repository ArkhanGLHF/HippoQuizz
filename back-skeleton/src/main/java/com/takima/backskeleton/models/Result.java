package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.Date;

@Getter
@Entity
@Table(name = "results")

public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;
    private Date dateCompleted;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private Result(Builder builder) {
        this.id = builder.id;
        this.score = builder.score;
        this.dateCompleted = builder.dateCompleted;
        this.user = builder.user;
        this.quiz = builder.quiz;
    }

    public Result() {

    }

    public static class Builder {
        private Long id;
        private int score;
        private Date dateCompleted;
        private User user;
        private Quiz quiz;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder score(int score) {
            this.score = score;
            return this;
        }

        public Builder dateCompleted(Date dateCompleted) {
            this.dateCompleted = dateCompleted;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
