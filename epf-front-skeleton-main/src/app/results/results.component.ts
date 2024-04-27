import { Component, OnInit } from '@angular/core';
import { map, Observable } from "rxjs"
import { Result } from "models/result.model"
import { ActivatedRoute, Router } from "@angular/router"
import { ResultService } from "services/result.service"

@Component({
  selector: 'epf-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.scss']
})
export class ResultsComponent {

  constructor(private _route: ActivatedRoute, private resultService: ResultService, private router: Router,) {
  }

  result$: Observable<Result[]> = this.resultService.findAll();

  deleteResult(event: any, result: Result) {
    event.stopPropagation()

    this.resultService.delete(result).subscribe(() => this.router.navigate(["results"])).add(() => window.location.reload())
  }

}
