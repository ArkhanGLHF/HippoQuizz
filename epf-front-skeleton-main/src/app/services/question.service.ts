import { Injectable } from '@angular/core';
import { Observable } from "rxjs"
import { Question } from "models/question.model"

import { HttpClient } from "@angular/common/http"

/**
 * Service to interact with the Question API
 */
@Injectable({
  providedIn: 'root'
})

export class QuestionService {
  constructor(private http: HttpClient) {
  }

  //Base URL for the Question API
  private questionsUrl = "http://localhost:8080/questions"

  /**
   * Retrieve all questions from the API
   * @returns Observable<Question[]> : An array of questions
   */
  findAll(): Observable<Question[]> {
    return this.http.get<Question[]>(this.questionsUrl)
  }

  /**
   * Retrieve a specific question from the API
   * @param id : number : The id of the question to retrieve
   * @returns Observable<Question> : The question with the specified id
   */
  findById(id: number): Observable<Question> {
    return this.http.get<Question>(`${this.questionsUrl}/${id}`)
  }

  /**
   * Retrieve all questions from the API
   * @param id : number : The id of the quiz to retrieve questions for
   * @returns Observable<Question[]> : An array of questions
   */
  getQuestionsByQuizId(id: number): Observable<Question[]> {
    return this.http.get<Question[]>( `${this.questionsUrl}/quiz/${id}`)
  }

  /**
   * Update a specific question in the API
   * @param id : number : The id of the question to update
   * @param question : Question : The updated question
   * @returns Observable<Question> : The updated question
   */
  update(id: number, question: Question): Observable<Question> {
    return this.http.post<Question>(`${this.questionsUrl}/${id}`, question)
  }

  /**
   * Create a new question in the API
   * @param question : The question to create
   * @returns Observable<Question> : The created question
   */
  create(question: Question): Observable<Question> {
    return this.http.post<Question>(this.questionsUrl, question)
  }

  /**
   * Delete a specific question from the API
   * @param question : Question : The question to delete
   */
  delete(question: Question) {
    return this.http.delete(`${this.questionsUrl}/${question.id}`)
  }

}
