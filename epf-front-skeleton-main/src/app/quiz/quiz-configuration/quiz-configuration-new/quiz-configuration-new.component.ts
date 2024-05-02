import { Component , OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuizService } from "services/quiz.service"

@Component({
  selector: "epf-quiz-configuration-new",
  templateUrl: "./quiz-configuration-new.component.html",
  styleUrls: ["./quiz-configuration-new.component.scss"],
})
export class QuizConfigurationNewComponent {
  constructor(
    private _route: ActivatedRoute,
    private quizService: QuizService,
    private router: Router,
  ) {
    
  }

  quiz$ : Observable<Quiz> = new Observable((observer) => observer.next({title: "", description: ""}))

  save(quiz: Quiz) {
    const id = this._route.snapshot.params["id"]

    this.quizService.create(quiz).subscribe(() => {
      this.router.navigate(["quiz-configuration"])
    })
    }
}
