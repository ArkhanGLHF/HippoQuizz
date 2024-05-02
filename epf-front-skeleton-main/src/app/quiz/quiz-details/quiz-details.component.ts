import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'services/quiz.service';
import { Quiz } from 'models/quiz.model';
import { Question } from 'models/question.model';

@Component({
  selector: 'epf-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.scss']
})
export class QuizDetailsComponent implements OnInit {
  quiz: Quiz;
  questions$: Question[] = [];
  currentQuestionIndex = 0;
  score = 0;
  showNextButton = false;
  showAnswerButton = true;
  showQuestionResult = true;
  showResultText = false;
  resultText = "";
  resultTextColor = "";

  constructor(private route: ActivatedRoute, private quizService: QuizService) {
    this.quiz = {} as Quiz;
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
      // Récupération des questions du quiz
      this.quizService.getQuestionsOfQuiz(id).subscribe(
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
    if(this.currentQuestionIndex < this.questions$.length - 1){
      // Passage à la question suivante
      this.currentQuestionIndex++;

      // Réinitialisation de l'affichage
      this.showQuestionResult = false;
      this.showNextButton = false;
      this.showAnswerButton = true;
      this.resultTextColor = "";
    }
  }

  getQuestionImageSrc(){
    return `assets/images/${this.quiz.id}/${this.currentQuestionIndex + 1}.png`;
  }
}
