import { Component , OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuizService } from "services/quiz.service"
import { Question } from "models/question.model"
import { QuestionService } from "services/question.service"

@Component({
  selector: "epf-quiz-configuration-new",
  templateUrl: "./quiz-configuration-new.component.html",
  styleUrls: ["./quiz-configuration-new.component.scss"],
})
export class QuizConfigurationNewComponent {

  quizCreated : boolean = false

  constructor(
    private _route: ActivatedRoute,
    private quizService: QuizService,
    private questionService: QuestionService,
    private router: Router,
  ) {
  }

  createQuestions(quiz: Quiz) {
    for (let i = 0; i < 10; i++) {
      this.questionService.create({
        questionText: "",
        questionAnswer: false,
        quiz: quiz
      }).subscribe(() => {

      });
    }
  }

  quiz$ : Observable<Quiz> = new Observable((observer) => observer.next({title: "", description: ""}))

  saveQuiz(quiz: Quiz) {

    this.quizService.create(quiz).subscribe(() => {
      this.quizCreated = true
      this.quiz$.subscribe((quiz) => {
        this.createQuestions(quiz)
      })
    })
  }

  quizQuestions: Observable<Question[]> = this.questionService.getQuestionsByQuizId(this._route.snapshot.params["id"]);

  saveQuestion(quizQuestions: Question[]) {

    for(let i = 0; i < 10; i++) {
      this.questionService.create(quizQuestions[i]).subscribe(() => {
      })
    }
    this.router.navigate(["quiz-configuration"])
  }

  range(length: number) {
    return Array.from({ length }, (_, i) => i);
  }
}
