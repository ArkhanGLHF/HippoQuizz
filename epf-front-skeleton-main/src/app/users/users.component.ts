import { Component } from "@angular/core"
import { map, Observable } from "rxjs"
import { User } from "models/user.model"
import { ActivatedRoute, Router } from "@angular/router"
import { UserService } from "services/user.service"

@Component({
  selector: 'epf-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent{
  constructor(private _route: ActivatedRoute, private userService: UserService, private router: Router) {
  }

  user$ : Observable<User[]> = this.userService.findAll();

  deleteUser(event: any, user: User) {
    event.stopPropagation()
    this.userService.delete(user).subscribe(() => this.router.navigate(["users"])).add(() => window.location.reload())  
  }
}
