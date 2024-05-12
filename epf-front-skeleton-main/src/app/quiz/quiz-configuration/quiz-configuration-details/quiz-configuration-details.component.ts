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

  /***
   * Save the update of questions and answers of the quiz
   * @param quizQuestions : Question[] : The questions of the quiz
   */
  saveQuestion(quizQuestions: Question[]) {
    //Update the 10 questions of the quiz
    for(let i = 0; i < 10; i++) {
      const questionId = Number(quizQuestions[i].id)

      //Update the questions and answers in the database
      this.questionService.update(questionId, quizQuestions[i]).subscribe(() => {
      })
    }
    //Navigate to the quiz configuration page
    this.router.navigate(["quiz-configuration"])
  }

  /***
   * Save the update quiz details (title and description)
   * @param quiz : Quiz : The quiz to update
  */
   saveQuiz(quiz: Quiz) {
    const id = this._route.snapshot.params["id"]

    //Update the quiz attributes in the database
    this.quizService.update(id, quiz).subscribe(() => {
    })
  }

  /***
   * Methode which call the two others above
   * @param quiz : Quiz : The quiz to update 
   * @param quizQuestions: Question[] : The questions of the quiz to update
   */
  save(quiz: Quiz, quizQuestions: Question[]) {

    this.saveQuiz(quiz)
    this.saveQuestion(quizQuestions)
  }

  /***
   * Method to browse the array of questions
   * @param length : number : The length of the array
   * @returns number[] : An array of numbers from 0 to length
   */
  range(length: number) {
    return Array.from({ length }, (_, i) => i);
  }

}
