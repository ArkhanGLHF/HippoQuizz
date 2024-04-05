import { Injectable } from '@angular/core';
import { Observable } from "rxjs"
import { Question } from "models/question.model"

// TODO Uncomment when Quiz model will be created
// import {Quiz} from "models/quiz.model"

import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: 'root'
})

export class QuestionService {
  constructor(private http: HttpClient) {
  }

  private questionsUrl = "http://localhost:8080/questions"

  findAll(): Observable<Question[]> {
    return this.http.get<Question[]>(this.questionsUrl)
  }

  findById(id: number): Observable<Question> {
    return this.http.get<Question>(`${this.questionsUrl}/${id}`)
  }

  update(id: number, question: Question): Observable<Question> {
    return this.http.post<Question>(`${this.questionsUrl}/${id}`, question)
  }

  create(question: Question): Observable<Question> {
    return this.http.post<Question>(this.questionsUrl, question)
  }

  delete(question: Question) {
    return this.http.delete(`${this.questionsUrl}/${question.id}`)
  }

}
