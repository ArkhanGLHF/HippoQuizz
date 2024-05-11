import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Question } from "models/question.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuestionService } from "services/question.service"

@Component({
  selector: "epf-question-details",
  templateUrl: "./question-details.component.html",
  styleUrls: ["./question-details.component.scss"],
})
export class QuestionDetailsComponent {
  
  constructor(
    private _route: ActivatedRoute,
    private questionService: QuestionService,
    private router: Router,
  ) {
    
  }

  question$ : Observable<Question> = this.questionService.findById( this._route.snapshot.params["id"]);

  save(question: Question) {
    const id = this._route.snapshot.params["id"]

    this.questionService.update(id, question).subscribe(() => {
      this.router.navigate(["questions"])
    })
    }
}
