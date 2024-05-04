package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

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

    private Result(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.quiz = builder.quiz;
        this.score = builder.score;
        this.dateCompleted = builder.dateCompleted;
    }

    public Result() {

    }

    public static class Builder {
        private Long id;
        private User user;
        private Quiz quiz;
        private int score;
        private Date dateCompleted;

        public Builder id (Long id) {
            this.id = id;
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

        public Builder score(int score) {
            this.score = score;
            return this;
        }

        public Builder dateCompleted(Date dateCompleted) {
            this.dateCompleted = dateCompleted;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
