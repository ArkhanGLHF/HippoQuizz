import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Result } from "models/result.model"
import { ActivatedRoute, Router } from "@angular/router"
import { ResultService } from "services/result.service"

@Component({
  selector: "epf-result-details",
  templateUrl: "./result-details.component.html",
  styleUrls: ["./result-details.component.scss"],
})
export class ResultDetailsComponent {
  // result$: Observable<Result> = this._route.data.pipe(map((data) => data["result"]))

  constructor(
    private _route: ActivatedRoute,
    private resultService: ResultService,
    private router: Router,
  ) {
    
  }

  result$ : Observable<Result> = this.resultService.findById( this._route.snapshot.params["id"]);

  save(result: Result) {
    const id = this._route.snapshot.params["id"]

    if (id == "new") {
      this.resultService.create(result).subscribe(() => {
        this.router.navigate(["results"])
      })
    } else {
      this.resultService.update(id, result).subscribe(() => {
        this.router.navigate(["results"])
      })
    }
  }

   
}
