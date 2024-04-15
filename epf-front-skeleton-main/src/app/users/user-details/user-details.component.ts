import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { User } from "models/user.model"
import { ActivatedRoute, Router } from "@angular/router"
import { UserService } from "services/user.service"

@Component({
  selector: "epf-user-details",
  templateUrl: "./user-details.component.html",
  styleUrls: ["./user-details.component.scss"],
})
export class UserDetailsComponent {
  // user$: Observable<User> = this._route.data.pipe(map((data) => data["user"]))

  constructor(
    private _route: ActivatedRoute,
    private userService: UserService,
    private router: Router,
  ) {
    
  }

  user$ : Observable<User> = this.userService.findById( this._route.snapshot.params["id"]);

  save(user: User) {
    const id = this._route.snapshot.params["id"]

    if (id == "new") {
      this.userService.create(user).subscribe(() => {
        this.router.navigate(["users"])
      })
    } else {
      this.userService.update(id, user).subscribe(() => {
        this.router.navigate(["users"])
      })
    }
  }
}
