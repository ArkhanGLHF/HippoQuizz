import { Component , OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { User } from "models/user.model"
import { ActivatedRoute, Router } from "@angular/router"
import { UserService } from "services/user.service"

@Component({
  selector: "epf-user-new",
  templateUrl: "./user-new.component.html",
  styleUrls: ["./user-new.component.scss"],
})
export class UserNewComponent {
  constructor(
    private _route: ActivatedRoute,
    private userService: UserService,
    private router: Router,
  ) {
    
  }

  user$ : Observable<User> = new Observable((observer) => observer.next({username: "", email: "", password: ""}))

  save(user: User) {
    const id = this._route.snapshot.params["id"]

    this.userService.create(user).subscribe(() => {
      this.router.navigate(["users"])
    })
    }
}
