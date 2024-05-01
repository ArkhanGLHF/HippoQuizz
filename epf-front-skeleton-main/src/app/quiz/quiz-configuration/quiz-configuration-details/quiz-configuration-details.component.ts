import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuizService } from "services/quiz.service"

@Component({
  selector: "epf-quiz-configuration-details",
  templateUrl: "./quiz-configuration-details.component.html",
  styleUrls: ["./quiz-configuration-details.component.scss"],
})
export class QuizConfigurationDetailsComponent {

  constructor(
    private _route: ActivatedRoute,
    private quizService: QuizService,
    private router: Router,
  ) {
    
  }

  quiz$ : Observable<Quiz> = this.quizService.findById( this._route.snapshot.params["id"]);

  save(quiz: Quiz) {
    const id = this._route.snapshot.params["id"]

    if (id == "new") {
      this.quizService.create(quiz).subscribe(() => {
        this.router.navigate(["quiz-configuration"])
      })
    } else {
      this.quizService.update(id, quiz).subscribe(() => {
        this.router.navigate(["quiz-configuration"])
      })
    }
  }
}
