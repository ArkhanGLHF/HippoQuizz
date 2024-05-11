import { Component, OnInit } from "@angular/core"
import { Link } from "models/links.model"

@Component({
  selector: "epf-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
  links: Link[] = []

  constructor() {
    this.links.push({ name: "Quiz", href: "quiz" })
    this.links.push({ name: "Results", href: "results" })
    this.links.push({ name: "Quiz", href : "quiz"})
    this.links.push({ name: "Question", href : "questions"})
  }
}
