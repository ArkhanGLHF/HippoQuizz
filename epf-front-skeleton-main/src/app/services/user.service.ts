import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { User } from "models/user.model"
import { HttpClient } from "@angular/common/http"

/**
 * Service to interact with the User API
 */
@Injectable({
  providedIn: "root",
})
export class UserService {
  constructor(private http: HttpClient) {
  }

  //Base URL for the User API
  private usersUrl = "http://localhost:8080/users"

  /**
   * Retrieve all users from the API
   * @returns Observable<User[]> : An array of users
   */
  findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
  }

  /**
   * Retrieve a specific user from the API
   * @param id : number : The id of the user to retrieve
   * @returns Observable<User> : The user with the specified id
   */
  findById(id: number): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/${id}`)
  }

  /**
   * Update a specific user in the API
   * @param id : number : The id of the user to update
   * @param user : User : The updated user
   * @returns Observable<User> : The updated user
   */
  update(id: number, user: User): Observable<User> {
    return this.http.post<User>(`${this.usersUrl}/${id}`, user)
  }

  /**
   * Create a new user in the API
   * @param user : The user to create
   * @returns Observable<User> : The created user
   */
  create(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user)
  }

  /**
   * Delete a specific user from the API
   * @param user : User : The user to delete
   */
  delete(user: User) {
    return this.http.delete(`${this.usersUrl}/${user.id}`)
  }
}
