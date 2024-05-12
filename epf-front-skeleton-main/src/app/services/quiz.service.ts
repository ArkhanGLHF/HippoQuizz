import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Quiz } from "models/quiz.model"
import { HttpClient } from "@angular/common/http"

/**
 * Service to interact with the Quiz API
 */
@Injectable({
    providedIn: 'root'
})

    export class QuizService {
        constructor(private http: HttpClient) {
    }

    //Base URL for the Quiz API
    private quizUrl = "http://localhost:8080/quiz"

    /**
     * Retrieve all quizzes from the API
     * @returns Observable<Quiz[]> : An array of quizzes
     */
    findAll(): Observable<Quiz[]> {
        return this.http.get<Quiz[]>(this.quizUrl)
    }

    /**
     * Retrieve a specific quiz from the API
     * @param id : number : The id of the quiz to retrieve
     * @returns Observable<Quiz> : The quiz with the specified id
     */
    findById(id: number): Observable<Quiz> {
        return this.http.get<Quiz>(`${this.quizUrl}/${id}`)
    }

    /**
     * Update a specific quiz in the API
     * @param id : number : The id of the quiz to update
     * @param quiz : Quiz : The updated quiz
     * @returns Observable<Quiz> : The updated quiz
     */
    update(id: number, quiz: Quiz): Observable<Quiz> {
        return this.http.post<Quiz>(`${this.quizUrl}-configuration-details/${id}`, quiz)
      }
    
    /**
     * Create a new quiz in the API
     * @param quiz : The quiz to create
     * @returns Observable<Quiz> : The created quiz
     */
    create(quiz: Quiz): Observable<Quiz> {
        return this.http.post<Quiz>(`${this.quizUrl}-configuration-new/`, quiz)
    }

    /**
     * Retrieve the last created quiz from the API
     * @returns Observable<Quiz> : The last created quiz
     */
    findLastCreated(): Observable<Quiz> {
        return this.http.get<Quiz>(`${this.quizUrl}-configuration-new/`)
    }
    
    /**
     * Delete a specific quiz from the API
     * @param quiz : Quiz : The quiz to delete
     */
    delete(quiz: Quiz) {
        return this.http.delete(`${this.quizUrl}-configuration/${quiz.id}`)
    }
}