package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;


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

    private Quiz(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
    }

    public Quiz() {
    }

    public static class Builder {
        private Long id;
        private String title;
        private String description;

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

        public Quiz build() {
            return new Quiz(this);
        }
    }
}
