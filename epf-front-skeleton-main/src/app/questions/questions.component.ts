import { Component, OnInit } from '@angular/core';
import { map, Observable } from "rxjs"
import { Question } from "models/question.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuestionService } from "services/question.service"

@Component({
  selector: 'epf-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.scss']
})
export class QuestionsComponent {

  constructor(private _route: ActivatedRoute, private questionService: QuestionService, private router: Router,) {
  }

  questions$: Observable<Question[]> = this.questionService.findAll();

  deleteQuestion(event: any, question: Question) {
    event.stopPropagation()
    this.questionService.delete(question).subscribe(() => this.router.navigate(["questions"]))
  }

}
