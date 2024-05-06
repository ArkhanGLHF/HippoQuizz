/* import { Component , OnInit } from "@angular/core"
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
  
  quiz$ : Observable<Quiz> = new Observable((observer) => observer.next({title: " ", description: " "}))

  retrieveQuiz : Quiz = {} as Quiz

  createQuestions(quiz: Quiz) {
    this.quizService.findLast().subscribe((retrievedQuiz: Quiz) => {
      this.retrieveQuiz = retrievedQuiz;

      for (let i = 0; i < 10; i++) {
        this.questionService.create({
          questionText: "",
          questionPicture: "",
          questionAnswer: false,
          quiz: this.retrieveQuiz
        }).subscribe(() => {

        })
      }
    });
  }

  saveQuiz(quiz: Quiz) {{
    this.quizService.create(quiz).subscribe(() => {
    })
    this.quizCreated = true
    this.createQuestions(quiz)
  }
  }

}
 */