import { Injectable } from "@angular/core"
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router"
import { Observable } from "rxjs"
import { UserService } from "services/user.service"
import { User } from "models/user.model"

@Injectable({
  providedIn: "root",
})
export class UserDetailsResolver implements Resolve<User> {
  constructor(private userService: UserService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<User> {
    if (route.params["id"] == "new") {
      return new Observable((observer) => observer.next({username: "", email: "", password: ""}))
    }
    return this.userService.findById(parseInt(route.params["id"], 10))
  }
}
