import { Injectable } from '@angular/core';
import { Observable } from "rxjs"
import { Result } from "models/result.model"

import { HttpClient } from "@angular/common/http"

/**
 * Service to interact with the Result API
 */
@Injectable({
  providedIn: 'root'
})

export class ResultService {
  constructor(private http: HttpClient) {
  }

  //Base URL for the Result API
  private resultsUrl = "http://localhost:8080/results"

  /**
   * Retrieve all results from the API
   * @returns Observable<Result[]> : An array of results
   */
  findAll(): Observable<Result[]> {
    return this.http.get<Result[]>(this.resultsUrl)
  }
  
  /**
   * Retrieve a specific result from the API
   * @param id : number : The id of the result to retrieve
   * @returns Observable<Result> : The result with the specified id
   */
  findById(id: number): Observable<Result> {
    return this.http.get<Result>(`${this.resultsUrl}/${id}`)
  }

  /**
   * Update a specific result in the API
   * @param id : number : The id of the result to update
   * @param result : Result : The updated result
   * @returns Observable<Result> : The updated result
   */
  update(id: number, result: Result): Observable<Result> {
    return this.http.post<Result>(`${this.resultsUrl}/${id}`, result)
  }

  /**
   * Create a new result in the API
   * @param result : The result to create
   * @returns Observable<Result> : The created result
   */
  create(result: Result): Observable<Result> {
    return this.http.post<Result>(this.resultsUrl, result)
  }

  /**
   * Delete a specific result from the API
   * @param result : Result : The result to delete
   */
  delete(result: Result) {
    return this.http.delete(`${this.resultsUrl}/${result.id}`)
  }
}
