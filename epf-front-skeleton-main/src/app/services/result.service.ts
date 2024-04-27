import { Injectable } from '@angular/core';
import { Observable } from "rxjs"
import { Result } from "models/result.model"

import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: 'root'
})

export class ResultService {
  constructor(private http: HttpClient) {
  }

  private resultsUrl = "http://localhost:8080/results"

  findAll(): Observable<Result[]> {
    return this.http.get<Result[]>(this.resultsUrl)
  }

  findById(id: number): Observable<Result> {
    return this.http.get<Result>(`${this.resultsUrl}/${id}`)
  }

  update(id: number, result: Result): Observable<Result> {
    return this.http.post<Result>(`${this.resultsUrl}/${id}`, result)
  }

  create(result: Result): Observable<Result> {
    return this.http.post<Result>(this.resultsUrl, result)
  }

  delete(result: Result) {
    return this.http.delete(`${this.resultsUrl}/${result.id}`)
  }

}
