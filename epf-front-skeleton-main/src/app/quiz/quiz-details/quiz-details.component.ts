import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'services/quiz.service';
import { Quiz } from 'models/quiz.model';
import { Question } from 'models/question.model';

@Component({
  selector: 'epf-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.scss']
})
export class QuizDetailsComponent implements OnInit {
  quiz: Quiz;
  questions$: Question[] = [];
  currentQuestionIndex = 0;
  score = 0;

  constructor(private route: ActivatedRoute, private quizService: QuizService) {
    this.quiz = {} as Quiz;
  }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(id != null) {
      this.quizService.findById(id).subscribe(
        (quiz) => {
          this.quiz = quiz;
        },
        (error) => {
          console.error('Error fetching quiz:', error);
        }
      );
      this.quizService.getQuestionsOfQuiz(id).subscribe(
        (questions) => {
          this.questions$ = questions;
        },
        (error) => {
          console.error('Error fetching questions:', error);
        }
      );
    }
  }

  submitAnswer(answer: boolean) {
    // TO EDIT WHEN ANSWER MODEL IS IMPLEMENTED
    if (this.currentQuestionIndex < this.questions$.length) {
      this.currentQuestionIndex++;
    }
  }
}
