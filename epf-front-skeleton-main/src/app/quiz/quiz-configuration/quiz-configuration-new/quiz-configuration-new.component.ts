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

  lastCreatedQuiz : Quiz 

  constructor(
    private _route: ActivatedRoute,
    private quizService: QuizService,
    private questionService: QuestionService,
    private router: Router,
  ) {
    this.lastCreatedQuiz = {} as Quiz
  }
  
  /***
   * Create 10 questions for the quiz
   * @param quiz : Quiz : The quiz to create the questions for
   */
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

  quizQuestions$: Observable<Question[]> = {} as Observable<Question[]>

  /***
   * Method to create a new quiz (title, description)
   * @param quiz : Quiz : The quiz to create
   */
  saveQuiz(quiz: Quiz) {
    //Creation of the quiz in the database with the title and description entered by the user
    this.quizService.create(quiz).subscribe(() => {
      
      //Retrieve the quiz that we just have created
      this.quizService.findLastCreated().subscribe((lastCreatedQuiz) => {
        //Save the last created quiz in the attribute lastCreatedQuiz
        this.lastCreatedQuiz = lastCreatedQuiz;

        //Create 10 default questions for the new quiz
        this.createQuestions(lastCreatedQuiz)
        //Navigate to the quiz configuration details page to fulfill the questions and answers
        this.router.navigate(["quiz-configuration-details/", lastCreatedQuiz.id])
      })
    })
  }
}
