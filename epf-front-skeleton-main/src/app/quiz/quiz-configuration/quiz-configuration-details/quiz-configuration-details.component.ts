import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuizService } from "services/quiz.service"

import { Question } from "models/question.model"
import { QuestionService } from "services/question.service"


@Component({
  selector: "epf-quiz-configuration-details",
  templateUrl: "./quiz-configuration-details.component.html",
  styleUrls: ["./quiz-configuration-details.component.scss"],
})
export class QuizConfigurationDetailsComponent {

  constructor(
    private _route: ActivatedRoute,
    private quizService: QuizService,
    private questionService: QuestionService,
    private router: Router,
  ) {
    
  }

  quiz$ : Observable<Quiz> = this.quizService.findById( this._route.snapshot.params["id"]);

  quizQuestions$: Observable<Question[]> = this.questionService.getQuestionsByQuizId(this._route.snapshot.params["id"]);

  saveQuestion(quizQuestions: Question[]) {
    for(let i = 0; i < 10; i++) {
      const questionId = Number(quizQuestions[i].id)

      this.questionService.update(questionId, quizQuestions[i]).subscribe(() => {
      })
    }
    this.router.navigate(["quiz-configuration"])
  }

   saveQuiz(quiz: Quiz) {
    const id = this._route.snapshot.params["id"]
    
    this.quizService.update(id, quiz).subscribe(() => {
    })
  }

  save(quiz: Quiz, quizQuestions: Question[]) {

    this.saveQuiz(quiz)
    this.saveQuestion(quizQuestions)
  }

  range(length: number) {
    return Array.from({ length }, (_, i) => i);
  }

}
