package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    List<Question> questions;

    private Quiz(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.questions = builder.questions;
    }

    public Quiz() {
    }

    public static class Builder {
        private Long id;
        private String title;
        private String description;
        private List<Question> questions;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder questions(List<Question> questions) {
            this.questions = questions;
            return this;
        }

        public Quiz build() {
            return new Quiz(this);
        }
    }
}
