import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router"
import { map, Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { QuizService } from "services/quiz.service"

@Component({
  selector: 'epf-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss']
})
export class QuizComponent implements OnInit {

  constructor(private _route: ActivatedRoute, private quizService: QuizService, private router: Router,) {
  }
  quiz$: Observable<Quiz[]> = this.quizService.findAll();

  ngOnInit(): void {
  }

}
