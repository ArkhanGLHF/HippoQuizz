import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'services/quiz.service';
import { Quiz } from 'models/quiz.model';
import { Question } from 'models/question.model';
import { Result } from 'models/result.model';
import { ResultService } from 'services/result.service';
import { User } from 'models/user.model';
import { UserService } from 'services/user.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';
import { QuestionService } from 'services/question.service';


@Component({
  selector: 'epf-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.scss']
})
export class QuizDetailsComponent implements OnInit {
  quiz: Quiz;
  user: User;
  result: Result;
  resultList$: Result[] = [];
  questions$: Question[] = [];
  currentQuestionIndex = 0;
  score= 0;
  showNextButton = false;
  showAnswerButton = true;
  showQuestionResult = true;
  showResultText = false;
  resultText = "";
  resultTextColor = "";
  showResult = false;
  showQuestions = false;
  showValidationSuccess = false;
  showPlayerSelection : boolean = true;
  selectedUserId: number = 0;

  constructor(private route: ActivatedRoute, private questionService: QuestionService, private quizService: QuizService, private resultService: ResultService, private userService: UserService, private router: Router) {
    this.quiz = {} as Quiz;
    this.user = {} as User;
    this.result = {} as Result;
  }

  ngOnInit() {
    // Récupération de l'ID du quiz
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(id != null) {
      // Récupération du quiz
      this.quizService.findById(id).subscribe(
        (quiz) => {
          this.quiz = quiz;
        },
        (error) => {
          console.error('Error fetching quiz:', error);
        }
      );
      
      this.questionService.getQuestionsByQuizId(id).subscribe(
        (questions) => {
          this.questions$ = questions;
        },
        (error) => {
          console.error('Error fetching questions:', error);
        }
      );
    }
  }

  submitAnswer(answer: boolean) {
    // Gestion du score et affichage du résultat
    if(this.questions$[this.currentQuestionIndex].questionAnswer === answer) {
      this.score++;
      this.resultText = "Bonne réponse ! Bien joué !";
      this.resultTextColor = "text-success";
    } else {
      this.resultText = "Mauvaise réponse ! Dommage !";
      this.resultTextColor = "text-danger";
    }
    // Affichage du résultat, du bouton suivant et disparition du bouton réponse
    this.showQuestionResult = true;
    this.showNextButton = true;
    this.showAnswerButton = false;
  }

  goToNextQuestion() {
    if (this.currentQuestionIndex < this.questions$.length - 1) {
      // Passage à la question suivante
      this.currentQuestionIndex++;
  
      // Réinitialisation de l'affichage
      this.showQuestionResult = false;
      this.showNextButton = false;
      this.showAnswerButton = true;
      this.resultTextColor = "";
    } else {
      // Affichage du résultat et du classement
      this.showResult = true;
      this.showQuestions = false;
      this.resultService.findAll().pipe(
        map(results => results.filter(result => result.quiz.id === this.quiz.id)),
        map(filteredResults => filteredResults.sort((a, b) => b.score - a.score)),
        map(sortedResults => sortedResults.slice(0, 5))
      ).subscribe(
        (topResults) => {
          this.resultList$ = topResults;
        },
        (error) => {
          console.error('Error fetching questions:', error);
        }
      );
    }
  }

  result$: Observable<Result> = new Observable((observer) => observer.next({user: this.user, quiz: this.quiz, score: this.score, dateCompleted: new Date()}))

  saveResult(result: Result) {
    const id = this.route.snapshot.params["id"]
    
    this.resultService.create(result).subscribe(() => {
      this.showValidationSuccess = true;
      this.showResult = false;       
    })
    
  }

  getQuestionImageSrc(){
    return `assets/images/${this.quiz.id}/${this.currentQuestionIndex + 1}.png`;
  }

  usersList$ = this.userService.findAll();

  startQuiz(){
    this.showQuestions = true;
  }

  selectPlayer(selectedUserId: number){ 
    this.userService.findById(selectedUserId).subscribe(
      (user) => {
        this.user = user;
        console.log("User selected: ", this.user);
      },
      (error) => {
        console.error('Error fetching user:', error);
      }
    );

    this.showPlayerSelection = false;
    this.startQuiz();
  }

}
