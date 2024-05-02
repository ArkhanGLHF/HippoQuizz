import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { HttpClient } from "@angular/common/http"
import { Question } from "models/question.model"

@Injectable({
    providedIn: 'root'
})

    export class QuizService {
        constructor(private http: HttpClient) {
    }

    private quizUrl = "http://localhost:8080/quiz"

    findAll(): Observable<Quiz[]> {
        return this.http.get<Quiz[]>(this.quizUrl)
    }

    findById(id: number): Observable<Quiz> {
        return this.http.get<Quiz>(`${this.quizUrl}/${id}`)
    }

/*     getQuestionsOfQuiz(id: number): Observable<Question[]> {
        return this.http.get<Question[]>(this.quizUrl + `/${id}/questions`)
      } */

    update(id: number, quiz: Quiz): Observable<Quiz> {
        return this.http.post<Quiz>(`${this.quizUrl}-configuration-details/${id}`, quiz)
      }
    
    create(quiz: Quiz): Observable<Quiz> {
        return this.http.post<Quiz>(`${this.quizUrl}-configuration-new/`, quiz)
    }
    
    delete(quiz: Quiz) {
        return this.http.delete(`${this.quizUrl}-configuration/${quiz.id}`)
    }
}