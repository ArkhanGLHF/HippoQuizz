import { Component } from "@angular/core"
import { map, Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { ActivatedRoute, Router } from "@angular/router"
import { QuizService } from "services/quiz.service"

@Component({
  selector: 'epf-quiz-configuration',
  templateUrl: './quiz-configuration.component.html',
  styleUrls: ['./quiz-configuration.component.scss']
})
export class QuizConfigurationComponent{

  constructor(private _route: ActivatedRoute, private quizService: QuizService, private router: Router,) {
  }

  quiz$ : Observable<Quiz[]> = this.quizService.findAll();

  deleteQuiz(event: any, quiz: Quiz) {
    event.stopPropagation()
    
    this.quizService.delete(quiz).subscribe(() => this.router.navigate(["quiz-configuration"])).add(() => window.location.reload())
  }
}
